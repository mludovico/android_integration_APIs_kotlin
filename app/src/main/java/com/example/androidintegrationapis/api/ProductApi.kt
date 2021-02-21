package com.example.androidintegrationapis.api

import com.example.androidintegrationapis.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductApi {

    @GET("getdata.php")
    fun getProductApi(): Call<List<Product>>

}