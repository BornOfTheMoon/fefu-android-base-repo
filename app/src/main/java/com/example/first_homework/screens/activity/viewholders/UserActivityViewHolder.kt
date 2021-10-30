package com.example.first_homework.screens.activity.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.first_homework.R
import com.example.first_homework.models.IActivity
import com.example.first_homework.models.IListItem
import com.example.first_homework.models.UserActivity

class UserActivityViewHolder(itemView: View, listener: (Int, IActivity) -> Unit)
    : ActivityViewHolder(itemView, listener) {
    private val tvUserName: TextView = itemView.findViewById(R.id.tvUserName)

    init {
        itemView.setOnClickListener {
            if (absoluteAdapterPosition != RecyclerView.NO_POSITION) {
                listener.invoke(absoluteAdapterPosition, data)
            }
        }
    }

    override fun bind(listItem: IListItem) {
        super.bind(listItem)
        listItem as UserActivity
        data = listItem
        tvUserName.text = listItem.userName
    }
}