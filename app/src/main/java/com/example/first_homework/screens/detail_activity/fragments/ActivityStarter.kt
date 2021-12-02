package com.example.first_homework.screens.detail_activity.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.first_homework.BaseFragment
import com.example.first_homework.R
import com.example.first_homework.databinding.FragmentActivityStarterBinding
import com.example.first_homework.models.ActivityType
import com.example.first_homework.screens.detail_activity.ActivitiesTypesViewAdapter

class ActivityStarter:
    BaseFragment<FragmentActivityStarterBinding>(R.layout.fragment_activity_starter)
{
    private val _adapter = ActivitiesTypesViewAdapter(listOf(
        ActivityType("Велосипед"),
        ActivityType("Бег"),
        ActivityType("Шаг"),
    ))

    private var selectedActivity: ActivityType? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


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
                val direction = ActivityStarterDirections
                    .actionActivityStarterToActivityActive(selectedActivity!!)
                findNavController().navigate(direction)
            }
        }
    }
}