package com.example.first_homework.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyActivity(
    val id: Int,
    override val name: String,
    override val startTime: String,
    override val metric: String,
    override val finishDate: String,
    override val duration: String,

    override val finishTime: String,
    override val type: ListItems = ListItems.MyCard
) : IActivity, Parcelable