package com.example.first_homework.screens.detail_activity.fragments

import android.os.Bundle
import android.view.View
import com.example.first_homework.BaseFragment
import com.example.first_homework.R
import com.example.first_homework.databinding.FragmentActivityActiveBinding
import com.example.first_homework.models.ActivityType

class ActivityActive:
    BaseFragment<FragmentActivityActiveBinding>(R.layout.fragment_activity_active)
{
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val activityType = requireArguments()["ActivityType"] as ActivityType

        binding.tvActivityType.text = activityType.name

        super.onViewCreated(view, savedInstanceState)
    }


}