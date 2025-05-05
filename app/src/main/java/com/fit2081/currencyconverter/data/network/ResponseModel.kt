package com.fit2081.currencyconverter.data.network

data class ResponseModel(var base: String, var rates: Map<String, Double>)
