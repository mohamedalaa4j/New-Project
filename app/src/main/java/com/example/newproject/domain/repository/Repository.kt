package com.example.newproject.domain.repository

import com.example.newproject.domain.model.ProductsDomainModel
import com.example.newproject.utiles.state.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getProducts(): Flow<Resource<ProductsDomainModel>>
}