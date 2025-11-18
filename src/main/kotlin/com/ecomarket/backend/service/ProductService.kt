package com.ecomarket.backend.service

import com.ecomarket.backend.dto.ProductDto
import com.ecomarket.backend.model.Product
import com.ecomarket.backend.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.NoSuchElementException // <-- Importante añadir esto

@Service
class ProductService(
    private val repo: ProductRepository
) {

    fun getAll(): List<ProductDto> =
        repo.findAll().map { it.toDto() }

    fun getById(id: String): ProductDto? =
        repo.findById(id).orElse(null)?.toDto()

    // --- CORRECCIÓN 1: MÉTODO CREATE ---
    // 1. Añadimos el tipo de retorno ProductDto
    fun create(dto: ProductDto): ProductDto {
        // 2. Guardamos, convertimos la respuesta a DTO y la devolvemos
        return repo.save(dto.toEntity()).toDto()
    }

    // --- CORRECCIÓN 2: MÉTODO UPDATE ---
    // 1. Añadimos el tipo de retorno ProductDto
    fun update(id: String, dto: ProductDto): ProductDto {
        if (repo.existsById(id)) {
            // 2. Guardamos, convertimos la respuesta a DTO y la devolvemos
            return repo.save(dto.toEntity()).toDto()
        }
        // 3. Si no existe, lanzamos un error
        throw NoSuchElementException("Producto con ID $id no encontrado.")
    }

    fun delete(id: String) {
        repo.deleteById(id)
    }
}

// --- Estas funciones de mapeo están perfectas ---
private fun Product.toDto() = ProductDto(
    id, name, price, imageUrl, category, description, discountPercent
)

private fun ProductDto.toEntity() = Product(
    id, name, price, imageUrl, category, description, discountPercent
)