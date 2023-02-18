package com.example.okcreditassessment.home.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.okcreditassessment.common.Status
import com.example.okcreditassessment.databinding.ActivityHomeBinding
import com.example.okcreditassessment.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    lateinit var binding : ActivityHomeBinding

    private val homeViewModel : HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun onStart() {
        super.onStart()
        initobserver()
        initviews()

    }

    private fun initobserver() {
        homeViewModel.topHeadlines.observe(this@HomeActivity) {
            when (it.status) {
                Status.SUCCESS -> {
                    Log.d("TAG_API", "data is :::: ${it.data}")
                }
                Status.ERROR -> {
                    Log.d("TAG_API", "Error")
                }
                Status.LOADING -> {
                    Log.d("TAG_API", "Loading")
                }
            }
        }
    }

    private fun initviews() {
        homeViewModel.getTopHeadLine()
    }
}