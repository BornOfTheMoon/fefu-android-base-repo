package com.example.first_homework.database

import android.os.Build
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.first_homework.extensions.*
import com.example.first_homework.models.ActivityType
import com.example.first_homework.models.ListItems
import com.example.first_homework.models.MyActivity
import java.time.Duration
import java.time.LocalDateTime

@Entity(tableName = "my_activities")
data class Activity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val type: ActivityType,
    val coordinates: List<Pair<Double, Double>>,
    @ColumnInfo(name = "start_time") val startTime: LocalDateTime,
    @ColumnInfo(name = "finish_time") val finishTime: LocalDateTime,
) {

    fun toMyActivity(): MyActivity {
        return MyActivity(
            id,
            type.title,
            coordinates.getDistance().toFormattedDistance(),
            finishTime.toFinishDateOrTime(),
            Duration.between(startTime, finishTime).toFormattedDurationBetween(),
            startTime.toTime(),
            finishTime.toTime(),
        )
    }
}