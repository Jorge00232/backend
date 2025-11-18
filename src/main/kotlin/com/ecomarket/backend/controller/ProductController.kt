package com.ecomarket.backend.controller

import com.ecomarket.backend.dto.ProductDto
import com.ecomarket.backend.service.ProductService
import org.springframework.http.HttpStatus // <-- Importa esto si lo usas
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController(
    private val service: ProductService
) {

    @GetMapping
    fun getAll(): List<ProductDto> =
        service.getAll()

    @GetMapping("/{id}")
    fun getOne(@PathVariable id: String): ProductDto? =
        service.getById(id)

    // --- CORRECCIÓN 1: MÉTODO CREATE ---
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Opcional, pero es una buena práctica
    fun create(@RequestBody dto: ProductDto): ProductDto { // <-- 1. Define el tipo de retorno
        return service.create(dto) // <-- 2. Asegúrate de que service.create() devuelva el DTO
    }

    // --- CORRECCIÓN 2: MÉTODO UPDATE ---
    @PutMapping("/{id}")
    fun update(
        @PathVariable id: String,
        @RequestBody dto: ProductDto
    ): ProductDto { // <-- 1. Define el tipo de retorno
        return service.update(id, dto) // <-- 2. Asegúrate de que service.update() devuelva el DTO
    }

    // --- MÉTODO DELETE (Está bien, no necesita devolver nada) ---
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Opcional, pero es una buena práctica
    fun delete(@PathVariable id: String) {
        service.delete(id)
    }
}