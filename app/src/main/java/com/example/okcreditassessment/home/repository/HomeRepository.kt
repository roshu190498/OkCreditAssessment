package com.example.okcreditassessment.home.repository

import com.example.okcreditassessment.common.enqueue
import com.example.okcreditassessment.home.api.HomeApis
import com.example.okcreditassessment.home.model.TopHeadLinesModel
import javax.inject.Inject

class HomeRepository @Inject constructor(private val homeApis: HomeApis) {

    fun getTopHeadLines(
        success: (topHeadLinesModel: TopHeadLinesModel) -> Unit,
        fail: (error: String) -> Unit ){
        homeApis.getTopHeadLines().enqueue {
            onResponse={
                it.body()?.let {
                    success.invoke(it)
                }?: kotlin.run {
                    fail.invoke("Something went wrong")
                }
            }
            onFailure={
                fail.invoke("Something went Wrong")
            }
        }
    }}