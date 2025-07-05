package com.example.newproject.domain.usecase

import com.example.newproject.domain.model.ProductsDomainModel
import com.example.newproject.domain.repository.Repository
import com.example.newproject.utiles.state.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(): Flow<Resource<ProductsDomainModel>> {
        return repository.getProducts()
    }
}