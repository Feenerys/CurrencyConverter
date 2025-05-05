package com.fit2081.currencyconverter.data.network

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("v1/latest") // specifies the endpoint relative to the base URL
    // The getRate method takes two parameters marked with @Query, which will be added as query parameters to the URL
    // The suspend keyword indicates this function should be called from a coroutine context
    // Response<ResponseModel> is the return type, using Retrofit's Response wrapper
    suspend fun getRate(@Query("base") base: String, @Query("symbols") symbols: String): Response<ResponseModel>

    // The companion object provides a factory method to create the API service
    companion object {
        var BASE_URL = "https://api.frankfurter.dev"

        fun create(): APIService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(APIService::class.java)
        }
    }
}