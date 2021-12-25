package com.example.first_homework.screens.activity

import com.example.first_homework.models.*

class Activities {
    companion object {
        @JvmStatic
        fun getUsersActivities(): List<IListItem> =
            listOf(
                DateSeparator("Вчера"),
                UserActivity(
                    name = "Бег",
                    metric = "14.32 км",
                    finishDate = "29.10.2021",
                    duration = "2 часа 46 минут",
                    startTime = "12:25",
                    finishTime = "15:11",
                    userName = "@morgen_shtern",
                    userComment = "Бежал, бежал и бежал..."
                ),

                UserActivity(
                    name = "Сёрфинг",
                    metric = "1 км",
                    finishDate = "29.10.2021",
                    duration = "1 час 40 минут",
                    startTime = "18:20",
                    finishTime = "20:00",
                    userName = "@van_darkholme",
                    userComment = "Утром пары, вечером сёрфинг"
                ),

                UserActivity(
                    name = "Велосипед",
                    metric = "3 км",
                    finishDate = "29.10.2021",
                    duration = "3 часа",
                    startTime = "06:07",
                    finishTime = "09:07",
                    userName = "@techniquepasha",
                    userComment = "I want to ride my bicycle"
                ),
            )
    }
}