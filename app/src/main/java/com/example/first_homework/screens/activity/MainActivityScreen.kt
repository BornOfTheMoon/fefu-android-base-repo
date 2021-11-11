package com.example.first_homework.screens.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.first_homework.R
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

open class MainActivityScreen: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_screen)

        val fragmentView = supportFragmentManager.findFragmentById(R.id.fvActivities) as NavHostFragment
        val navController = fragmentView.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.nvActivitiesAndProfile)

        bottomNavigationView.setupWithNavController(navController)
    }
}