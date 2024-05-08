package com.example.testtask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.testtask.model.ProductResponse
import com.example.testtask.network.RetrofitInstance

class MainActivity : AppCompatActivity() {
    private lateinit var productAdapter: ProductAdapter
    private lateinit var recyclerViewProducts: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализация recyclerViewProducts
        recyclerViewProducts = findViewById(R.id.recyclerViewProducts)

        // Настройка RecyclerView
        recyclerViewProducts.layoutManager = LinearLayoutManager(this)
        productAdapter = ProductAdapter(emptyList())
        recyclerViewProducts.adapter = productAdapter

        // Выполнение сетевого запроса для получения продуктов
        val productService = RetrofitInstance.productService
        productService.getProducts(0, 20).enqueue(object : Callback<ProductResponse> {
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if (response.isSuccessful) {
                    val products = response.body()?.products ?: emptyList()
                    productAdapter = ProductAdapter(products)
                    recyclerViewProducts.adapter = productAdapter
                } else {
                    // Обработка ошибки
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                // Обработка ошибки
            }
        })
    }

}