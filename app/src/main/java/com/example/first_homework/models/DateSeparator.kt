package com.example.first_homework.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DateSeparator(
    val formattedDate: String,
    override val type: ListItems = ListItems.DateSeparator
) : IListItem, Parcelable