package com.example.first_homework.screens.activity.viewholders

import android.view.View
import android.widget.TextView
import com.example.first_homework.R
import com.example.first_homework.models.IActivity
import com.example.first_homework.models.IListItem
import com.example.first_homework.models.UserActivity

class UserActivityViewHolder(itemView: View, listener: (Int, IActivity) -> Unit)
    : ActivityViewHolder(itemView, listener) {
    private val tvUserName: TextView = itemView.findViewById(R.id.tvUserName)

    override fun bind(listItem: IListItem) {
        super.bind(listItem)
        listItem as UserActivity
        data = listItem
        tvUserName.text = listItem.userName
    }
}