package com.example.first_homework.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.AutoMigration


@TypeConverters(Converters::class)
@Database(
    version = 2,
    entities = [Activity::class],
    exportSchema = true,
)
abstract class ActivitiesDataBase: RoomDatabase() {
    abstract fun activityDao(): ActivityDao
}