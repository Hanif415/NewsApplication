package com.example.newsapplication.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newsapplication.data.source.local.entity.*

@Database(
    entities = [BusinessEntity::class, EntertainmentEntity::class, HeadLinesEntity::class, HealthEntity::class, SearchNewsEntity::class, SportsEntity::class, TechnologyEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao

    companion object {
        @Volatile
        private var INSTANCE: NewsDatabase? = null

        fun getInstance(context: Context): NewsDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    NewsDatabase::class.java,
                    "newsDb.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }
}