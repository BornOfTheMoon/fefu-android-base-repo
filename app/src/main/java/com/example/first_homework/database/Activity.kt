package com.example.first_homework.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.first_homework.extensions.*
import com.example.first_homework.models.ActivityType
import com.example.first_homework.models.MyActivity
import java.time.Duration
import java.time.LocalDateTime

@Entity(tableName = "my_activities")
data class Activity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val type: ActivityType,
    @ColumnInfo(name = "start_time") val startTime: LocalDateTime,
    val coordinates: List<Pair<Double, Double>>,
    @ColumnInfo(name = "finish_time") val finishTime: LocalDateTime?,
) {
    fun toMyActivity(): MyActivity {
        return MyActivity(
            id,
            type.title,
            startTime.toTime(),
            coordinates.getDistance().toFormattedDistance(),
            finishTime!!.toFinishDateOrTime(),
            Duration.between(startTime, finishTime).toFormattedDurationBetween(),
            finishTime.toTime(),
        )
    }
}

data class ActivityPathUpdate(
    val id: Int,
    val coordinates: List<Pair<Double, Double>>,
)

data class ActivityFinishTimeUpdate(
    val id: Int,
    @ColumnInfo(name = "finish_time") val finishTime: LocalDateTime,
)
