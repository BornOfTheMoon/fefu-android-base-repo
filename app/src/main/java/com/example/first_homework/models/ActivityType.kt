package com.example.first_homework.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ActivityType (
    val name: String
) : Parcelable