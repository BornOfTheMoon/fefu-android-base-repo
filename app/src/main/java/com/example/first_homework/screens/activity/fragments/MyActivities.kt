package com.example.first_homework.screens.activity.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.first_homework.BaseFragment
import com.example.first_homework.R
import com.example.first_homework.databinding.FragmentMyActivitiesBinding
import com.example.first_homework.models.MyActivity
import com.example.first_homework.screens.activity.Activities
import com.example.first_homework.screens.activity.adapters.ActivitiesViewAdapter

class MyActivities:
    BaseFragment<FragmentMyActivitiesBinding>(R.layout.fragment_my_activities){
    private val activities = Activities.getMyActivities()

    private val _adapter = ActivitiesViewAdapter(activities)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.lvActivities) {
            adapter = _adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        _adapter.setMyItemClickListener {
                _, activityData ->
            run {
                val action =
                    ActivitiesDirections.
                    actionActivitiesFragmentToMyActivityInfo(activityData as MyActivity)
                findNavController().navigate(action)
            }
        }
    }
}