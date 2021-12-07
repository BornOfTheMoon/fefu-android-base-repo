package com.example.first_homework.screens.activity.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.first_homework.R
import com.example.first_homework.models.*
import com.example.first_homework.screens.activity.viewholders.DateSeparatorViewHolder
import com.example.first_homework.screens.activity.viewholders.ListItemViewHolder
import com.example.first_homework.screens.activity.viewholders.ActivityViewHolder
import com.example.first_homework.screens.activity.viewholders.UserActivityViewHolder

class ActivitiesViewAdapter
    : ListAdapter<IListItem, ListItemViewHolder>(ListItemCallback()) {

    private var myItemClickListener: (Int, IActivity) -> Unit =
        { _: Int, _: IActivity -> }
    private var userItemClickListener: (Int, IActivity) -> Unit =
        { _: Int, _: IActivity ->}

    override fun getItemViewType(position: Int): Int {
        return currentList[position].type.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        return when (viewType) {
            ListItems.MyCard.ordinal -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.activity_card, parent, false)
                ActivityViewHolder(view, myItemClickListener)
            }
            ListItems.UserCard.ordinal -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.activity_card, parent, false)
                UserActivityViewHolder(view, userItemClickListener)
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.date_separator, parent, false)
                DateSeparatorViewHolder(view)
            }
        }

    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    fun setMyItemClickListener(listener: (Int, IActivity) -> Unit) {
        myItemClickListener = listener
    }
    fun setUserItemClickListener(listener: (Int, IActivity) -> Unit) {
        userItemClickListener = listener
    }
}

internal class ListItemCallback : DiffUtil.ItemCallback<IListItem>() {
    override fun areItemsTheSame(oldItem: IListItem, newItem: IListItem): Boolean {
        return when {
            oldItem.type == ListItems.DateSeparator &&
                    newItem.type == ListItems.DateSeparator -> {
                (oldItem as DateSeparator).formattedDate == (newItem as DateSeparator).formattedDate
            }
            oldItem.type == ListItems.MyCard && newItem.type == ListItems.MyCard ->
                (oldItem as MyActivity).id == (newItem as MyActivity).id

            else -> false
        }
    }

    override fun areContentsTheSame(oldItem: IListItem, newItem: IListItem): Boolean {
        return when {
            oldItem.type == ListItems.DateSeparator &&
                    newItem.type == ListItems.DateSeparator ->
                areItemsTheSame(oldItem, newItem)

            oldItem.type == ListItems.MyCard && newItem.type == ListItems.MyCard ->
                (oldItem as MyActivity) == (newItem as MyActivity)

            else -> false
        }

    }
}