package com.example.newsapplication.data.source

import androidx.paging.DataSource
import com.example.newsapplication.data.source.local.entity.*
import com.example.newsapplication.data.source.local.room.NewsDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val dao: NewsDao) {
    fun getBusinessNews(): DataSource.Factory<Int, BusinessEntity> = dao.getBusinessNews()

    fun insertBusinessNews(businessList: List<BusinessEntity>) =
        dao.insertBusinessNews(businessList)

    fun getEntertainmentNews(): DataSource.Factory<Int, EntertainmentEntity> =
        dao.getEntertainmentNews()

    fun insertEntertainment(entertainmentList: List<EntertainmentEntity>) =
        dao.insertEntertainmentNews(entertainmentList)

    fun getHeadlinesNews(): DataSource.Factory<Int, HeadLinesEntity> =
        dao.getHeadlinesNews()

    fun insertHeadlinesNews(headlinesNews: List<HeadLinesEntity>) =
        dao.insertHeadlinesNews(headlinesNews)

    fun getHealthNews(): DataSource.Factory<Int, HealthEntity> =
        dao.getHealthNews()

    fun insertHealthNews(healthNews: List<HealthEntity>) =
        dao.insertHealthNews(healthNews)

    fun getSportNews(): DataSource.Factory<Int, SportsEntity> =
        dao.getSportNews()

    fun insertSportNews(sportNews: List<SportsEntity>) =
        dao.insertSportNews(sportNews)

    fun getTechnologyNews(): DataSource.Factory<Int, TechnologyEntity> =
        dao.getTechnologyNews()

    fun insertTechnologyNews(technologyNews: List<TechnologyEntity>) =
        dao.insertTechnologyNews(technologyNews)

    fun getSearchNews(): DataSource.Factory<Int, SearchNewsEntity> =
        dao.getSearchNews()

    fun insertSearchNews(searchNewsNews: List<SearchNewsEntity>) =
        dao.insertSearchNews(searchNewsNews)
}