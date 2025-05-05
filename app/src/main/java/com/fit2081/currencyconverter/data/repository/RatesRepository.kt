package com.fit2081.currencyconverter.data.repository

import com.fit2081.currencyconverter.data.network.APIService
import com.fit2081.currencyconverter.data.network.ResponseModel

class RatesRepository() {
    private val apiService = APIService.create()

    suspend fun getRate(base: String, symbols: String): ResponseModel? {
        return apiService.getRate(base,symbols).body()
    }
}