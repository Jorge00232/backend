package com.ecomarket.backend.service

import com.ecomarket.backend.dto.ProductDto
import com.ecomarket.backend.model.Product
import com.ecomarket.backend.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val repo: ProductRepository
) {

    fun getAll(): List<ProductDto> =
        repo.findAll().map { it.toDto() }

    fun getById(id: String): ProductDto? =
        repo.findById(id).orElse(null)?.toDto()

    fun create(dto: ProductDto) {
        repo.save(dto.toEntity())
    }

    fun update(id: String, dto: ProductDto) {
        if (repo.existsById(id)) {
            repo.save(dto.toEntity())
        }
    }

    fun delete(id: String) {
        repo.deleteById(id)
    }
}

private fun Product.toDto() = ProductDto(
    id, name, price, imageUrl, category, description, discountPercent
)

private fun ProductDto.toEntity() = Product(
    id, name, price, imageUrl, category, description, discountPercent
)
