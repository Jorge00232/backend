package com.ecomarket.backend.service

import com.ecomarket.backend.dto.ProductDto
import com.ecomarket.backend.model.Product
import com.ecomarket.backend.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.NoSuchElementException

@Service
class ProductService(
    private val repo: ProductRepository
) {

    fun getAll(): List<ProductDto> =
        repo.findAll().map { it.toDto() }

    fun getById(id: String): ProductDto? =
        repo.findById(id).orElse(null)?.toDto()


    fun create(dto: ProductDto): ProductDto {
        return repo.save(dto.toEntity()).toDto()
    }

    fun update(id: String, dto: ProductDto): ProductDto {
        if (repo.existsById(id)) {
            return repo.save(dto.toEntity()).toDto()
        }
        throw NoSuchElementException("Producto con ID $id no encontrado.")
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