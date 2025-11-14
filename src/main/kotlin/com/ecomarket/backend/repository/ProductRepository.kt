package com.ecomarket.backend.repository

import com.ecomarket.backend.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, String>
