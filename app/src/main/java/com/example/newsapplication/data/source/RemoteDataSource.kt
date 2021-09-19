package com.example.newsapplication.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapplication.data.source.remote.response.ApiResponse
import com.example.newsapplication.data.source.remote.response.ArticlesItem
import com.example.newsapplication.service.NewsApi
import com.example.newsapplication.utils.EspressoIdlingResource
import com.example.newsapplication.utils.Utils.getCountry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class RemoteDataSource @Inject constructor() {

    fun getHeadLinesNews(): LiveData<ApiResponse<List<ArticlesItem>>> {
        EspressoIdlingResource.increment()

        val resultNews = MutableLiveData<ApiResponse<List<ArticlesItem>>>()
        val country = getCountry()

        CoroutineScope(Dispatchers.IO).launch {
            val result = NewsApi.newsApiService.getHeadLines(country)
            resultNews.postValue(ApiResponse.success(result.articles!!))
        }

        EspressoIdlingResource.decrement()

        return resultNews
    }

    fun getSportNews(): LiveData<ApiResponse<List<ArticlesItem>>> {
        EspressoIdlingResource.increment()

        val resultNews = MutableLiveData<ApiResponse<List<ArticlesItem>>>()
        val country = getCountry()

        CoroutineScope(Dispatchers.IO).launch {
            val result = NewsApi.newsApiService.getSport(country, "sport")
            resultNews.postValue(ApiResponse.success(result.articles!!))
        }

        EspressoIdlingResource.decrement()

        return resultNews
    }

    fun getTechnologyNews(): LiveData<ApiResponse<List<ArticlesItem>>> {
        EspressoIdlingResource.increment()

        val resultNews = MutableLiveData<ApiResponse<List<ArticlesItem>>>()
        val country = getCountry()

        CoroutineScope(Dispatchers.IO).launch {
            val result = NewsApi.newsApiService.getTechnology(country, "technology")
            resultNews.postValue(ApiResponse.success(result.articles!!))
        }

        EspressoIdlingResource.decrement()

        return resultNews
    }

    fun getBusinessNews(): LiveData<ApiResponse<List<ArticlesItem>>> {
        EspressoIdlingResource.increment()

        val resultNews = MutableLiveData<ApiResponse<List<ArticlesItem>>>()
        val country = getCountry()

        CoroutineScope(Dispatchers.IO).launch {
            val result = NewsApi.newsApiService.getBusiness(country, "business")
            resultNews.postValue(ApiResponse.success(result.articles!!))
        }

        EspressoIdlingResource.decrement()

        return resultNews
    }

    fun getHealthNews(): LiveData<ApiResponse<List<ArticlesItem>>> {
        EspressoIdlingResource.increment()

        val resultNews = MutableLiveData<ApiResponse<List<ArticlesItem>>>()
        val country = getCountry()

        CoroutineScope(Dispatchers.IO).launch {
            val result = NewsApi.newsApiService.getHealth(country, "health")
            resultNews.postValue(ApiResponse.success(result.articles!!))
        }

        EspressoIdlingResource.decrement()

        return resultNews
    }

    fun getEntertainmentNews(): LiveData<ApiResponse<List<ArticlesItem>>> {
        EspressoIdlingResource.increment()

        val resultNews = MutableLiveData<ApiResponse<List<ArticlesItem>>>()
        val country = getCountry()

        CoroutineScope(Dispatchers.IO).launch {
            val result = NewsApi.newsApiService.getEntertainment(country, "entertainment")
            resultNews.postValue(ApiResponse.success(result.articles!!))
        }

        EspressoIdlingResource.decrement()

        return resultNews
    }

    fun getSearchNews(keyword: String): LiveData<ApiResponse<List<ArticlesItem>>> {
        EspressoIdlingResource.increment()

        val resultNews = MutableLiveData<ApiResponse<List<ArticlesItem>>>()

        CoroutineScope(Dispatchers.IO).launch {
            val result = NewsApi.newsApiService.getNewsSearch(keyword, "id")
            resultNews.postValue(ApiResponse.success(result.articles!!))
        }

        EspressoIdlingResource.decrement()

        return resultNews
    }
}