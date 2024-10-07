package com.weslaine.projeto_intermediario.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weslaine.projeto_intermediario.dtos.ProductRequestDTO;
import com.weslaine.projeto_intermediario.dtos.ProductResponseDTO;
import com.weslaine.projeto_intermediario.services.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductResponseDTO create(@RequestBody @Valid ProductRequestDTO productRequestDTO) {
        return productService.create(productRequestDTO);
    }

    @GetMapping
    public List<ProductResponseDTO> getAll() {
        return productService.getAll();
    }

}
