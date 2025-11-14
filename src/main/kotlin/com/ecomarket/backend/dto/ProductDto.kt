package com.ecomarket.backend.dto

data class ProductDto(
    val id: String,
    val name: String,
    val price: Double,
    val imageUrl: String,
    val category: String,
    val description: String,
    val discountPercent: Int?
)
