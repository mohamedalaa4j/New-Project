package com.example.newproject.data.repository

import com.example.newproject.data.datasource.remote.AppApi
import com.example.newproject.domain.mapper.toProductsDomainModel
import com.example.newproject.domain.model.ProductsDomainModel
import com.example.newproject.domain.repository.Repository
import com.example.newproject.utiles.state.ApiState
import com.example.newproject.utiles.state.Resource
import com.example.newproject.utiles.toResultFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val appApi: AppApi
) : Repository {
    override suspend fun getProducts(): Flow<Resource<ProductsDomainModel>> {
        return flow {
            val result = toResultFlow { appApi.getProducts() }
            result.collect { apiState ->
                when (apiState) {
                    is ApiState.Loading -> emit(Resource.Loading())
                    is ApiState.Error -> emit(Resource.Error(apiState.message!!))
                    is ApiState.Success -> {
                        emit(Resource.Success(apiState.data?.toProductsDomainModel()))
                    }
                }
            }
        }
    }
}