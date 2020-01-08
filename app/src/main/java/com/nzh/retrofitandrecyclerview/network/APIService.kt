package com.nzh.retrofitandrecyclerview.network


import com.nzh.retrofitandrecyclerview.model.Region
import retrofit2.Call
import retrofit2.http.*

interface APIService  {

    @GET("region")
    fun getRegion():Call<List<Region>>
}