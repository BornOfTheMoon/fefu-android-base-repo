package com.example.first_homework.models

import com.example.first_homework.screens.activity.ListItems

data class DateSeparator(
    val formattedDate: String,
    override val type: ListItems = ListItems.DateSeparator,
) : IListItem