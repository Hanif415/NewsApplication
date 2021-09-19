package com.example.newsapplication.data.source.local.room

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsapplication.data.source.local.entity.*

@Dao
interface NewsDao {
    @Query("SELECT * FROM businessNews")
    fun getBusinessNews(): DataSource.Factory<Int, BusinessEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBusinessNews(newsList: List<BusinessEntity>)

    @Query("SELECT * FROM entertainmentNews")
    fun getEntertainmentNews(): DataSource.Factory<Int, EntertainmentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEntertainmentNews(newsList: List<EntertainmentEntity>)

    @Query("SELECT * FROM headlineNews")
    fun getHeadlinesNews(): DataSource.Factory<Int, HeadLinesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHeadlinesNews(newsList: List<HeadLinesEntity>)

    @Query("SELECT * FROM healthNews")
    fun getHealthNews(): DataSource.Factory<Int, HealthEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHealthNews(newsList: List<HealthEntity>)

    @Query("SELECT * FROM searchNews")
    fun getSearchNews(): DataSource.Factory<Int, SearchNewsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSearchNews(listNews: List<SearchNewsEntity>)

    @Query("SELECT * FROM sportsNews")
    fun getSportNews(): DataSource.Factory<Int, SportsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSportNews(newsList: List<SportsEntity>)

    @Query("SELECT * FROM technologyNews")
    fun getTechnologyNews(): DataSource.Factory<Int, TechnologyEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTechnologyNews(newsList: List<TechnologyEntity>)
}