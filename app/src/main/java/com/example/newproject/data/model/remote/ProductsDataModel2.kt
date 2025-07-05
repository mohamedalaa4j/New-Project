package com.example.newproject.data.model.remote


import com.google.gson.annotations.SerializedName

class ProductsDataModel2 : ArrayList<ProductsDataModel2.ProductsDataModel2Item>(){
    data class ProductsDataModel2Item(
        @SerializedName("category") val category: Category?,
        @SerializedName("creationAt") val creationAt: String?,
        @SerializedName("description") val description: String?,
        @SerializedName("id") val id: Int?,
        @SerializedName("images") val images: List<String?>?,
        @SerializedName("price") val price: Int?,
        @SerializedName("slug") val slug: String?,
        @SerializedName("title") val title: String?,
        @SerializedName("updatedAt") val updatedAt: String?
    ) {
        data class Category(
            @SerializedName("creationAt") val creationAt: String?,
            @SerializedName("id") val id: Int?,
            @SerializedName("image") val image: String?,
            @SerializedName("name") val name: String?,
            @SerializedName("slug") val slug: String?,
            @SerializedName("updatedAt") val updatedAt: String?
        )
    }
}