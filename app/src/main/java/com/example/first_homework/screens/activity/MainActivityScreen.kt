package com.example.first_homework.screens.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.first_homework.R
import com.example.first_homework.App
import com.example.first_homework.cicerone_extentions.ExtendedAppNavigator
import com.example.first_homework.databinding.MainActivityScreenBinding
import com.example.first_homework.screens.activity.adapters.BottomNavigationViewAdapter

open class MainActivityScreen: AppCompatActivity() {
    private lateinit var binding: MainActivityScreenBinding

    private lateinit var bottomNavigationViewAdapter: BottomNavigationViewAdapter

    private val navigator by lazy { ExtendedAppNavigator(this, R.id.fvActivities) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val screens = listOf(
            ScreenItem (
                R.id.activitiesFragment,
                Screens.activitiesScreen(),
            ),
            ScreenItem(
                R.id.profileFragment,
                Screens.profileScreen(),
            )
        )

        App.INSTANCE.router.newRootScreen(screens[0].screen)


        bottomNavigationViewAdapter = BottomNavigationViewAdapter(
            binding.nvActivitiesAndProfile,
            screens
        )

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.INSTANCE.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        App.INSTANCE.navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        App.INSTANCE.router.exit()
    }
}