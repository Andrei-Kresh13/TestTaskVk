package com.example.testtask.network

import com.example.testtask.model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    @GET("/products")
    fun getProducts(
        @Query("skip") skip: Int,
        @Query("limit") limit: Int
    ): Call<ProductResponse>
}