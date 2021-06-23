package com.example.mvvmretrofitrecyclerviewpractice

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllMovies() = retrofitService.getAllMovies()
}