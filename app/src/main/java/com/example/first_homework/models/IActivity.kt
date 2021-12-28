package com.example.first_homework.models

interface IActivity: IListItem {
    val name: String
    val startTime: String
    val metric: String
    val finishDate: String
    val duration: String

    val finishTime: String
    override val type: ListItems
}