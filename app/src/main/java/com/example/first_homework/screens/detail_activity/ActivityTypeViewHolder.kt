package com.example.first_homework.screens.detail_activity

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.first_homework.R
import com.example.first_homework.models.ActivityType

class ActivityTypeViewHolder(
    view: View,
    listener: (Int, ActivityType) -> Unit
): RecyclerView.ViewHolder(view) {
    private val tvActivityType: TextView = view.findViewById(R.id.tvType)
    private lateinit var activityType: ActivityType

    init {
        view.setOnClickListener {
            if (absoluteAdapterPosition != RecyclerView.NO_POSITION) {
                listener.invoke(absoluteAdapterPosition, activityType)
            }
        }
    }

    @SuppressLint
    fun bind(type: ActivityType) {
        tvActivityType.text = type.name
        activityType = type

    }
}