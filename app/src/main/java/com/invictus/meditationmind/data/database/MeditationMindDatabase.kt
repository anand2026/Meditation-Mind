package com.invictus.meditationmind.data.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.invictus.meditationmind.data.database.periodTrack.PeriodTrackModel
import com.invictus.meditationmind.data.database.periodTrack.PeriodTrackerDao
import splitties.init.appCtx

@Database(entities = [PeriodTrackModel::class], version = 1, exportSchema = false)
abstract class MeditationMindDatabase : RoomDatabase() {

    abstract fun periodTrackerDao(): PeriodTrackerDao

    companion object {

        private var INSTANCE: MeditationMindDatabase? = null

        fun getInstance(): MeditationMindDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(appCtx, MeditationMindDatabase::class.java, "meditationmind")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }

    }
}

