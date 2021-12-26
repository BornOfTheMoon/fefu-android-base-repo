package com.example.first_homework.screens.detail_activity.fragments

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.first_homework.App
import com.example.first_homework.BaseFragment
import com.example.first_homework.R
import com.example.first_homework.database.Activity
import com.example.first_homework.databinding.FragmentActivityStarterBinding
import com.example.first_homework.models.ActivityType
import com.example.first_homework.screens.detail_activity.ActivitiesTypesViewAdapter
import java.time.LocalDateTime
import com.example.first_homework.screens.detail_activity.ActivityActivity
import com.example.first_homework.screens.detail_activity.ActivityService

class ActivityStarter:
    BaseFragment<FragmentActivityStarterBinding>(R.layout.fragment_activity_starter)
{
    private val _adapter = ActivitiesTypesViewAdapter(listOf(*ActivityType.values()))


    private var selectedActivity: ActivityType? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if ((activity as ActivityActivity).activityId != -1) {
            val navController = findNavController()
            navController.navigate(
                ActivityStarterDirections.actionActivityStarterToActivityActive(
                    (activity as ActivityActivity).activityId,
                    true
                )
            )
        }

        with(binding.recyclerView) {
            adapter = _adapter
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }


        _adapter.setItemClickListener {
                position, activityType ->
            selectedActivity = activityType
            for(i in 0..binding.recyclerView.layoutManager?.itemCount!!) {
                binding.recyclerView.layoutManager?.findViewByPosition(i)?.isSelected=false
            }
            binding.recyclerView.layoutManager?.findViewByPosition(position)?.isSelected=true
        }

        binding.bStart.setOnClickListener {
            selectedActivity?.let {

                val activityId = App.INSTANCE.database.activityDao().insert(
                    Activity(
                        0,
                        selectedActivity!!,
                        listOf(),
                        LocalDateTime.now(),
                        null
                    )
                ).toInt()
                val direction = ActivityStarterDirections
                    .actionActivityStarterToActivityActive(activityId, false)

                findNavController().navigate(direction)
            }
        }
    }
}