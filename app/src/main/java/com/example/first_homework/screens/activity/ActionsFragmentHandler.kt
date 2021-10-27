package com.example.first_homework.screens.activity

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ActionsFragmentHandler(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return if (position == Tabs.My.position) {
            MyActivitiesFragment.newInstance()
        } else {
            UsersActivitiesFragment.newInstance()
        }
    }
}