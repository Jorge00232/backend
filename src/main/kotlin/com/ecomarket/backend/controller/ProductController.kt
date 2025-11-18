package com.ecomarket.backend.controller

import com.ecomarket.backend.dto.ProductDto
import com.ecomarket.backend.service.ProductService
import org.springframework.http.HttpStatus
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
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody dto: ProductDto): ProductDto {
        return service.create(dto)
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: String,
        @RequestBody dto: ProductDto
    ): ProductDto {
        return service.update(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        service.delete(id)
    }
}