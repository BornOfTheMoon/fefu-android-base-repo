package com.example.first_homework.cicerone_extentions

import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Screen

data class Hide(
    val screen: Screen,
    val fragmentId: Int,
): Command