package com.example.first_homework.screens.activity.viewholders

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.first_homework.models.IListItem
import com.example.first_homework.R
import com.example.first_homework.models.IActivity

open class ActivityViewHolder(itemView: View, listener: (Int, IActivity) -> Unit)
    : ListItemViewHolder(itemView) {
    private val tvMetric: TextView = itemView.findViewById(R.id.tvMetric)
    private val tvTime: TextView = itemView.findViewById(R.id.tvTime)
    private val tvActivityType: TextView = itemView.findViewById(R.id.tvActivityName)
    private val tvDate: TextView = itemView.findViewById(R.id.tvDate)
    protected lateinit var data: IActivity

    init {
        itemView.setOnClickListener {
            if (absoluteAdapterPosition != RecyclerView.NO_POSITION)
                listener.invoke(absoluteAdapterPosition, data)
        }
    }

    @SuppressLint
    override fun bind(listItem: IListItem) {
        listItem as IActivity
        data = listItem
        tvMetric.text = listItem.metric
        tvTime.text = listItem.duration
        tvActivityType.text = listItem.name
        tvDate.text = listItem.finishDate
    }
}