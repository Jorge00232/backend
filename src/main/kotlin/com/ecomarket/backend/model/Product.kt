package com.ecomarket.backend.model

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Product(
    @Id
    val id: String,
    val name: String,
    val price: Double,
    val imageUrl: String,
    val category: String,
    val description: String,
    val discountPercent: Int?
)
