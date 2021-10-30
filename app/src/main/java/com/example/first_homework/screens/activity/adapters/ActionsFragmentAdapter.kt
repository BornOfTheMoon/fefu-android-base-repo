package com.example.first_homework.screens.activity.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.first_homework.screens.activity.Tabs
import com.example.first_homework.screens.activity.fragments.MyActivitiesFragment
import com.example.first_homework.screens.activity.fragments.UsersActivitiesFragment
import java.util.*

class ActionsFragmentAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return if (position == Tabs.My.position) {
            MyActivitiesFragment.newInstance()
        } else {
            UsersActivitiesFragment.newInstance()
        }
    }
}