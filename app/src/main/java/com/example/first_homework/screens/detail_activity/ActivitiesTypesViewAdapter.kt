package com.example.first_homework.screens.detail_activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.first_homework.R
import com.example.first_homework.models.ActivityType

class ActivitiesTypesViewAdapter
    (activitiesTypes: List<ActivityType>)
    : RecyclerView.Adapter<ActivityTypeViewHolder>() {

    private val types = activitiesTypes.toMutableList()

    private var itemClickListener: (Int, ActivityType) -> Unit = {
            _, _ ->
    }

    fun setItemClickListener(listener: (Int, ActivityType) -> Unit) {
        itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityTypeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_type_card,
            parent,
            false)

        return ActivityTypeViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: ActivityTypeViewHolder, position: Int) {
        holder.bind(types[position])
    }

    override fun getItemCount(): Int = types.count()
}