package com.example.okcreditassessment.home.api

import com.example.okcreditassessment.home.model.TopHeadLinesModel
import com.example.okcreditassessment.network.API_KEY
import com.example.okcreditassessment.network.COUNTRY_CODE
import com.example.okcreditassessment.network.TOP_HEADLINES
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApis {
    @GET(TOP_HEADLINES)
    fun getTopHeadLines(
        @Query("country") country: String = COUNTRY_CODE,
        @Query("apiKey") apiKey : String = API_KEY
        ) : Call<TopHeadLinesModel>
}