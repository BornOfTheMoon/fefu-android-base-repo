package com.example.first_homework.screens.activity.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.first_homework.models.IListItem

abstract class ListItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bind(listItem: IListItem)
}