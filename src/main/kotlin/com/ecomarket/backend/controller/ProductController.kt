package com.ecomarket.backend.controller

import com.ecomarket.backend.dto.ProductDto
import com.ecomarket.backend.service.ProductService
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

    @PostMapping
    fun create(@RequestBody dto: ProductDto) =
        service.create(dto)

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: String,
        @RequestBody dto: ProductDto
    ) = service.update(id, dto)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) =
        service.delete(id)
}
