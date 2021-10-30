package com.example.first_homework.screens.activity.adapters

import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.first_homework.App
import com.example.first_homework.screens.activity.ScreenItem

class BottomNavigationViewAdapter(
    private val navBar: BottomNavigationView,
    private val screenItems: List<ScreenItem>,
) {

    init {
        setListeners()
    }

    private fun setListeners() {
        navBar.setOnItemSelectedListener(::onItemSelected)
    }

    private fun onItemSelected(menuItem: MenuItem): Boolean {
        for (screenItem in screenItems) {
            if (screenItem.id == menuItem.itemId) {
                App.INSTANCE.router.navigateTo(screenItem.screen)
                break
            }
        }
        return true
    }
}