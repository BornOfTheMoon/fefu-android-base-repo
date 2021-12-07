package com.example.first_homework.screens.activity.fragments.activities

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.first_homework.BaseFragment
import com.example.first_homework.R
import com.example.first_homework.databinding.FragmentUsersActivitiesBinding
import com.example.first_homework.models.UserActivity
import com.example.first_homework.screens.activity.Activities
import com.example.first_homework.screens.activity.adapters.ActivitiesViewAdapter

class UsersActivities:
    BaseFragment<FragmentUsersActivitiesBinding>(R.layout.fragment_users_activities) {
    private val activities = Activities.getUsersActivities()

    private val _adapter = ActivitiesViewAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.lvActivities) {
            adapter = _adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        _adapter.setUserItemClickListener {
                _, iActivity ->
            run {
                val action = ActivitiesDirections.
                actionActivitiesFragmentToUserActivityInfo(iActivity as UserActivity)
                findNavController().navigate(action)
            }
        }
    }
}