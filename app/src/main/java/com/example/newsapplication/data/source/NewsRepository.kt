package com.example.newsapplication.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.newsapplication.data.source.local.entity.*
import com.example.newsapplication.data.source.remote.response.ApiResponse
import com.example.newsapplication.data.source.remote.response.ArticlesItem
import com.example.newsapplication.utils.AppExecutors
import com.example.newsapplication.vo.Resource
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class NewsRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutor: AppExecutors,
) : NewsDataSource {

    override fun getBusinessNews(): LiveData<Resource<PagedList<BusinessEntity>>> {
        return object :
            NetworkBoundResource<PagedList<BusinessEntity>, List<ArticlesItem>>(appExecutor) {
            override fun shouldFetch(data: PagedList<BusinessEntity>?): Boolean =
                data == null || data.isEmpty()


            override fun loadFromDb(): LiveData<PagedList<BusinessEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getBusinessNews(), config).build()
            }

            override fun createCall(): LiveData<ApiResponse<List<ArticlesItem>>> =
                remoteDataSource.getBusinessNews()

            override fun saveCallResult(data: List<ArticlesItem>?) {
                val newsList = ArrayList<BusinessEntity>()

                for (response in data!!) {
                    val news = BusinessEntity(
                        response.url.toString(),
                        response.publishedAt.toString(),
                        response.author.toString(),
                        response.urlToImage.toString(),
                        response.description.toString(),
                        response.source?.name.toString(),
                        response.title.toString(),
                        response.url.toString(),
                        response.content.toString()
                    )

                    newsList.add(news)
                }

                localDataSource.insertBusinessNews(newsList)
            }
        }.asLiveData()
    }

    override fun getEntertainmentNews(): LiveData<Resource<PagedList<EntertainmentEntity>>> {
        return object :
            NetworkBoundResource<PagedList<EntertainmentEntity>, List<ArticlesItem>>(appExecutor) {
            override fun shouldFetch(data: PagedList<EntertainmentEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun loadFromDb(): LiveData<PagedList<EntertainmentEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getEntertainmentNews(), config).build()
            }

            override fun createCall(): LiveData<ApiResponse<List<ArticlesItem>>> =
                remoteDataSource.getEntertainmentNews()

            override fun saveCallResult(data: List<ArticlesItem>?) {
                val newsList = ArrayList<EntertainmentEntity>()

                for (response in data!!) {
                    val news = EntertainmentEntity(
                        response.url.toString(),
                        response.publishedAt.toString(),
                        response.author.toString(),
                        response.urlToImage.toString(),
                        response.description.toString(),
                        response.source?.name.toString(),
                        response.title.toString(),
                        response.url.toString(),
                        response.content.toString()
                    )

                    newsList.add(news)
                }

                localDataSource.insertEntertainment(newsList)
            }
        }.asLiveData()
    }

    override fun getHeadlinesNews(): LiveData<Resource<PagedList<HeadLinesEntity>>> {
        return object :
            NetworkBoundResource<PagedList<HeadLinesEntity>, List<ArticlesItem>>(appExecutor) {
            override fun shouldFetch(data: PagedList<HeadLinesEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun loadFromDb(): LiveData<PagedList<HeadLinesEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getHeadlinesNews(), config).build()
            }

            override fun createCall(): LiveData<ApiResponse<List<ArticlesItem>>> =
                remoteDataSource.getHeadLinesNews()

            override fun saveCallResult(data: List<ArticlesItem>?) {
                val newsList = ArrayList<HeadLinesEntity>()

                for (response in data!!) {
                    val news = HeadLinesEntity(
                        response.url.toString(),
                        response.publishedAt.toString(),
                        response.author.toString(),
                        response.urlToImage.toString(),
                        response.description.toString(),
                        response.source?.name.toString(),
                        response.title.toString(),
                        response.url.toString(),
                        response.content.toString()
                    )

                    newsList.add(news)
                }

                localDataSource.insertHeadlinesNews(newsList)
            }
        }.asLiveData()
    }

    override fun getHealthNews(): LiveData<Resource<PagedList<HealthEntity>>> {
        return object :
            NetworkBoundResource<PagedList<HealthEntity>, List<ArticlesItem>>(appExecutor) {
            override fun shouldFetch(data: PagedList<HealthEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun loadFromDb(): LiveData<PagedList<HealthEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getHealthNews(), config).build()
            }

            override fun createCall(): LiveData<ApiResponse<List<ArticlesItem>>> =
                remoteDataSource.getHealthNews()

            override fun saveCallResult(data: List<ArticlesItem>?) {
                val newsList = ArrayList<HealthEntity>()

                for (response in data!!) {
                    val news = HealthEntity(
                        response.url.toString(),
                        response.publishedAt.toString(),
                        response.author.toString(),
                        response.urlToImage.toString(),
                        response.description.toString(),
                        response.source?.name.toString(),
                        response.title.toString(),
                        response.url.toString(),
                        response.content.toString()
                    )

                    newsList.add(news)
                }

                localDataSource.insertHealthNews(newsList)
            }
        }.asLiveData()
    }

    override fun getSearchNews(keyword: String): LiveData<Resource<PagedList<SearchNewsEntity>>> {
        return object :
            NetworkBoundResource<PagedList<SearchNewsEntity>, List<ArticlesItem>>(appExecutor) {
            override fun shouldFetch(data: PagedList<SearchNewsEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun loadFromDb(): LiveData<PagedList<SearchNewsEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getSearchNews(), config).build()
            }

            override fun createCall(): LiveData<ApiResponse<List<ArticlesItem>>> =
                remoteDataSource.getSearchNews(keyword)

            override fun saveCallResult(data: List<ArticlesItem>?) {
                val newsList = ArrayList<SearchNewsEntity>()

                for (response in data!!) {
                    val news = SearchNewsEntity(
                        response.url.toString(),
                        response.publishedAt.toString(),
                        response.author.toString(),
                        response.urlToImage.toString(),
                        response.description.toString(),
                        response.source?.name.toString(),
                        response.title.toString(),
                        response.url.toString(),
                        response.content.toString()
                    )

                    newsList.add(news)
                }

                localDataSource.insertSearchNews(newsList)
            }
        }.asLiveData()
    }

    override fun getSportNews(): LiveData<Resource<PagedList<SportsEntity>>> {
        return object :
            NetworkBoundResource<PagedList<SportsEntity>, List<ArticlesItem>>(appExecutor) {
            override fun shouldFetch(data: PagedList<SportsEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun loadFromDb(): LiveData<PagedList<SportsEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getSportNews(), config).build()
            }

            override fun createCall(): LiveData<ApiResponse<List<ArticlesItem>>> =
                remoteDataSource.getSportNews()

            override fun saveCallResult(data: List<ArticlesItem>?) {
                val newsList = ArrayList<SportsEntity>()

                for (response in data!!) {
                    val news = SportsEntity(
                        response.url.toString(),
                        response.publishedAt.toString(),
                        response.author.toString(),
                        response.urlToImage.toString(),
                        response.description.toString(),
                        response.source?.name.toString(),
                        response.title.toString(),
                        response.url.toString(),
                        response.content.toString()
                    )

                    newsList.add(news)
                }

                localDataSource.insertSportNews(newsList)
            }
        }.asLiveData()
    }

    override fun getTechnologyNews(): LiveData<Resource<PagedList<TechnologyEntity>>> {
        return object :
            NetworkBoundResource<PagedList<TechnologyEntity>, List<ArticlesItem>>(appExecutor) {
            override fun shouldFetch(data: PagedList<TechnologyEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun loadFromDb(): LiveData<PagedList<TechnologyEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getTechnologyNews(), config).build()
            }

            override fun createCall(): LiveData<ApiResponse<List<ArticlesItem>>> =
                remoteDataSource.getTechnologyNews()

            override fun saveCallResult(data: List<ArticlesItem>?) {
                val newsList = ArrayList<TechnologyEntity>()

                for (response in data!!) {
                    val news = TechnologyEntity(
                        response.url.toString(),
                        response.publishedAt.toString(),
                        response.author.toString(),
                        response.urlToImage.toString(),
                        response.description.toString(),
                        response.source?.name.toString(),
                        response.title.toString(),
                        response.url.toString(),
                        response.content.toString()
                    )

                    newsList.add(news)
                }

                localDataSource.insertTechnologyNews(newsList)
            }
        }.asLiveData()
    }
}