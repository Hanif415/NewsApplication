package com.example.newsapplication.data.source.remote.response

import retrofit2.http.Body

class ApiResponse<T>(val status: StatusResponse, val body: T, val message: String?) {
    companion object {
        fun <T> success(body: T): ApiResponse<T> = ApiResponse(StatusResponse.SUCCESS, body, null)

        fun <T> empty(msg: String?, body: T): ApiResponse<T> =
            ApiResponse(StatusResponse.ERROR, body, msg)

        fun <T> error(msg: String?, body: T): ApiResponse<T> =
            ApiResponse(StatusResponse.ERROR, body, msg)
    }
}