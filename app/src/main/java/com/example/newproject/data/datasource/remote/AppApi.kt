package com.example.newproject.data.datasource.remote

import com.example.newproject.data.model.remote.ProductsDataModel
import com.example.newproject.data.model.remote.ProductsDataModel2
import retrofit2.Response
import retrofit2.http.GET

interface AppApi {
    companion object {
        const val BASE_URL = "https://api.escuelajs.co/api/v1/"
        const val PRODUCTS_ENDPOINT = "products"
    }

    @GET(PRODUCTS_ENDPOINT)
    suspend fun getProducts(): Response<ProductsDataModel2>
}