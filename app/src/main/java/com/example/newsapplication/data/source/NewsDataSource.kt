package com.example.newsapplication.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

import com.example.newsapplication.data.source.local.entity.*
import com.example.newsapplication.vo.Resource

interface NewsDataSource {
    fun getBusinessNews(): LiveData<Resource<PagedList<BusinessEntity>>>

    fun getEntertainmentNews(): LiveData<Resource<PagedList<EntertainmentEntity>>>

    fun getHeadlinesNews(): LiveData<Resource<PagedList<HeadLinesEntity>>>

    fun getHealthNews(): LiveData<Resource<PagedList<HealthEntity>>>

    fun getSearchNews(keyword: String): LiveData<Resource<PagedList<SearchNewsEntity>>>

    fun getSportNews(): LiveData<Resource<PagedList<SportsEntity>>>

    fun getTechnologyNews(): LiveData<Resource<PagedList<TechnologyEntity>>>
}