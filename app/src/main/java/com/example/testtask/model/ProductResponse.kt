package com.example.testtask.model

import com.example.testtask.model.Product

data class ProductResponse(
    val products: List<Product>,
    val total: Int,
    val skip: Int,
    val limit: Int
)

