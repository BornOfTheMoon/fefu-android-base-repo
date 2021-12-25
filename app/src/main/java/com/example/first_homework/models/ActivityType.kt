package com.example.first_homework.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class ActivityType(val title: String) : Parcelable {
    Run("Бег"),
    Hike("Шаг"),
    Bicycle("Велосипед")
}