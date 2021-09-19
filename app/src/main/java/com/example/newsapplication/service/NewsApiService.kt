package com.example.newsapplication.service

import com.example.newsapplication.data.source.remote.response.NewsResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://newsapi.org/v2/"
private const val API_KEY = "09f0da02db16499a90e3c6b452b9a49d"

val loggingHttpInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

val client = OkHttpClient.Builder().addInterceptor(loggingHttpInterceptor).build()

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL).client(client)
    .build()

interface NewsApiService {
    @GET("top-headlines")
    suspend fun getHeadLines(
        @Query("country") country: String?,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse

    @GET("top-headlines")
    suspend fun getSport(
        @Query("country") country: String?,
        @Query("category") category: String?,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse

    @GET("top-headlines")
    suspend fun getTechnology(
        @Query("country") country: String?,
        @Query("category") category: String?,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse

    @GET("top-headlines")
    suspend fun getBusiness(
        @Query("country") country: String?,
        @Query("category") category: String?,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse

    @GET("top-headlines")
    suspend fun getHealth(
        @Query("country") country: String?,
        @Query("category") category: String?,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse

    @GET("top-headlines")
    suspend fun getEntertainment(
        @Query("country") country: String?,
        @Query("category") category: String?,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse

    @GET("everything")
    suspend fun getNewsSearch(
        @Query("q") keyword: String?,
        @Query("language") language: String?,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse
}

object NewsApi {
    val newsApiService: NewsApiService by lazy {
        retrofit.create(NewsApiService::class.java)
    }
}
