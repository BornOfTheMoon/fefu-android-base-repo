package com.example.first_homework.screens.activity.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.first_homework.screens.activity.fragments.activities.MyActivities
import com.example.first_homework.screens.activity.fragments.activities.UsersActivities

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle)
    : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> MyActivities()
            else -> UsersActivities()
        }
    }
}