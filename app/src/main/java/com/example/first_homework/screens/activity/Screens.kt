package com.example.first_homework.screens.activity

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.example.first_homework.models.MyActivity
import com.example.first_homework.models.UserActivity
import com.example.first_homework.screens.activity.fragments.*

object Screens {
    fun activitiesScreen() = FragmentScreen { ActivitiesFragment.newInstance() }
    fun profileScreen() = FragmentScreen { ProfileFragment.newInstance() }
    fun activityInfoScreen(activity: MyActivity) = FragmentScreen { MyActivityInfoFragment.newInstance(activity) }
    fun userActivityInfoScreen(activity: UserActivity) = FragmentScreen {
        UserActivityInfoFragment.newInstance(activity)
    }
}