package com.example.newproject.presentation.model

import com.example.newproject.domain.model.ProductsDomainModel

data class HomeState(
    var isLoading: Boolean = false,
    val products: ProductsDomainModel? = null
)