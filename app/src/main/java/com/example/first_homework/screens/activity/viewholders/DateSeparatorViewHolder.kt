package com.example.first_homework.screens.activity.viewholders

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import com.example.first_homework.R
import com.example.first_homework.models.DateSeparator
import com.example.first_homework.models.IListItem

class DateSeparatorViewHolder(itemView: View): ListItemViewHolder(itemView) {
    private val tvDate: TextView = itemView.findViewById(R.id.tvDateSeparator)

    @SuppressLint
    override fun bind(listItem: IListItem) {
        listItem as DateSeparator

        tvDate.text = listItem.formattedDate
    }
}