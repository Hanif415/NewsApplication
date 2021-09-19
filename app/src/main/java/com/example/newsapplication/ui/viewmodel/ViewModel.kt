package com.example.newsapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList


import com.example.newsapplication.data.source.NewsRepository
import com.example.newsapplication.data.source.local.entity.*
import com.example.newsapplication.utils.GenerateHighLightData
import com.example.newsapplication.vo.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel() {

    fun getBusinessNews(): LiveData<Resource<PagedList<BusinessEntity>>> =
        newsRepository.getBusinessNews()

    fun getEntertainmentNews(): LiveData<Resource<PagedList<EntertainmentEntity>>> =
        newsRepository.getEntertainmentNews()

    fun getHeadlineNews(): LiveData<Resource<PagedList<HeadLinesEntity>>> =
        newsRepository.getHeadlinesNews()

    fun geHealthNews(): LiveData<Resource<PagedList<HealthEntity>>> =
        newsRepository.getHealthNews()

    fun getSearchNews(keyword: String): LiveData<Resource<PagedList<SearchNewsEntity>>> =
        newsRepository.getSearchNews(keyword)

    fun getSportsNews(): LiveData<Resource<PagedList<SportsEntity>>> =
        newsRepository.getSportNews()

    fun getTechnologyNews(): LiveData<Resource<PagedList<TechnologyEntity>>> =
        newsRepository.getTechnologyNews()

}