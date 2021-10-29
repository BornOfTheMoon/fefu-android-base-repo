package com.example.first_homework.screens.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.first_homework.R
import com.example.first_homework.databinding.MainActivityScreenBinding
import com.example.first_homework.screens.NavBarHandler

class MainActivityScreen: AppCompatActivity() {
    private lateinit var _binding: MainActivityScreenBinding
    private lateinit var _navBarHandler: NavBarHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = MainActivityScreenBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        setupStartActivity(savedInstanceState)
        setupNavBarHandler()

    }

    private fun setupNavBarHandler() {
        _navBarHandler = NavBarHandler(
            _binding.bottomNavBar,
            supportFragmentManager,
            listOf(
                NavBarHandler.FragmentItem(
                    R.id.actionTab,
                    ActivitiesFragment.TAG,
                    ActivitiesFragment::newInstance
                ),
                NavBarHandler.FragmentItem(
                    R.id.profileTab,
                    ProfileFragment.TAG,
                    ProfileFragment::newInstance
                )
            ),
            R.id.contentView
        )
    }

    private fun setupStartActivity(savedInstanceState: Bundle?) {
        savedInstanceState?.let {} ?: supportFragmentManager.beginTransaction().apply {
            add(
                R.id.contentView,
                ActivitiesFragment.newInstance(),
                ActivitiesFragment.TAG
            )
            commit()
        }
    }
}