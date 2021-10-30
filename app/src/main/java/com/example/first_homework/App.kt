package com.example.first_homework

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import com.example.first_homework.cicerone_extentions.ExtendedRouter

class App: Application() {

    companion object {
        lateinit var INSTANCE: App
    }

    private val cicerone = Cicerone.create(ExtendedRouter())

    val router: ExtendedRouter
        get() = cicerone.router


    val navigatorHolder: NavigatorHolder
        get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}