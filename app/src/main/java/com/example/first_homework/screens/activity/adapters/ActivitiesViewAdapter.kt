package com.example.first_homework.screens.activity.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.first_homework.models.IListItem
import com.example.first_homework.R
import com.example.first_homework.models.IActivity
import com.example.first_homework.models.MyActivity
import com.example.first_homework.models.UserActivity
import com.example.first_homework.screens.activity.ListItems.MyCard
import com.example.first_homework.screens.activity.ListItems.UserCard
import com.example.first_homework.screens.activity.viewholders.DateSeparatorViewHolder
import com.example.first_homework.screens.activity.viewholders.ListItemViewHolder
import com.example.first_homework.screens.activity.viewholders.ActivityViewHolder
import com.example.first_homework.screens.activity.viewholders.UserActivityViewHolder

class ActivitiesViewAdapter(staticActivities: List<IListItem>)
    : RecyclerView.Adapter<ListItemViewHolder>() {

    private val activities = staticActivities.toMutableList()
    private var myItemClickListener: (Int, IActivity) -> Unit =
        { position: Int, data: IActivity -> }
    private var userItemClickListener: (Int, IActivity) -> Unit =
        { position: Int, data: IActivity ->}

    override fun getItemViewType(position: Int): Int {
        return activities[position].type.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        return when (viewType) {
            MyCard.ordinal -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.activity_card, parent, false)
                ActivityViewHolder(view, myItemClickListener)
            }
            UserCard.ordinal -> {
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

    override fun getItemCount(): Int = activities.size

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(activities[position])
    }

    fun setMyItemClickListener(listener: (Int, IActivity) -> Unit) {
        myItemClickListener = listener
    }
    fun setUserItemClickListener(listener: (Int, IActivity) -> Unit) {
        userItemClickListener = listener
    }
}