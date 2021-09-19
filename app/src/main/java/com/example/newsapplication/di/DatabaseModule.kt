package com.example.newsapplication.di

import android.content.Context
import com.example.newsapplication.data.source.local.room.NewsDao
import com.example.newsapplication.data.source.local.room.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): NewsDatabase =
        NewsDatabase.getInstance(appContext)

    @Provides
    fun providesNewsDao(database: NewsDatabase): NewsDao = database.newsDao()
}