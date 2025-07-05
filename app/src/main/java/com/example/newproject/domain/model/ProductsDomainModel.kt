package com.example.newproject.domain.model

data class ProductsDomainModel(
    val products: List<ProductItemDomainModel>
)

data class ProductItemDomainModel(
    val category: CategoryDomainModel?,
    val creationAt: String?,
    val description: String?,
    val id: Int?,
    val images: List<String?>?,
    val price: Int?,
    val slug: String?,
    val title: String?,
    val updatedAt: String?
)

data class CategoryDomainModel(
    val creationAt: String?,
    val id: Int?,
    val image: String?,
    val name: String?,
    val slug: String?,
    val updatedAt: String?
)