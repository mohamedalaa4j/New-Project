package com.example.newproject.domain.mapper

import com.example.newproject.data.model.remote.ProductsDataModel
import com.example.newproject.data.model.remote.ProductsDataModel2
import com.example.newproject.domain.model.CategoryDomainModel
import com.example.newproject.domain.model.ProductItemDomainModel
import com.example.newproject.domain.model.ProductsDomainModel

fun ProductsDataModel.toProductsDomainModel(): ProductsDomainModel {
    return ProductsDomainModel(
        products = this.products.map {
            ProductItemDomainModel(
                category = CategoryDomainModel(
                    creationAt = it.category?.creationAt,
                    id = it.category?.id,
                    image = it.category?.image,
                    name = it.category?.name,
                    slug = it.category?.slug,
                    updatedAt = it.category?.updatedAt
                ),
                creationAt = it.creationAt,
                description = it.description,
                id = it.id,
                images = it.images,
                price = it.price,
                slug = it.slug,
                title = it.title,
                updatedAt = it.updatedAt
            )
        }
    )
}

fun ProductsDataModel2.toProductsDomainModel(): ProductsDomainModel {
    return ProductsDomainModel(
        products = this.map {
            ProductItemDomainModel(
                category = CategoryDomainModel(
                    creationAt = it.category?.creationAt,
                    id = it.category?.id,
                    image = it.category?.image,
                    name = it.category?.name,
                    slug = it.category?.slug,
                    updatedAt = it.category?.updatedAt
                ),
                creationAt = it.creationAt,
                description = it.description,
                id = it.id,
                images = it.images,
                price = it.price,
                slug = it.slug,
                title = it.title,
                updatedAt = it.updatedAt
            )
        }
    )
}

