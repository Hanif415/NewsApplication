package com.example.newsapplication.di

import com.example.newsapplication.utils.AppExecutors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    fun providesAppExecutor(): AppExecutors {
        return AppExecutors()
    }
}