package com.weslaine.projeto_intermediario.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import com.weslaine.projeto_intermediario.dtos.ProductRequestDTO;
import com.weslaine.projeto_intermediario.dtos.ProductResponseDTO;
import com.weslaine.projeto_intermediario.mappers.ProductMapper;
import com.weslaine.projeto_intermediario.models.ProductEntity;
import com.weslaine.projeto_intermediario.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductResponseDTO create(ProductRequestDTO productRequestDTO) {
        return productMapper.toResponse(productRepository.save(productMapper.toEntity(productRequestDTO)));
    }

    public List<ProductResponseDTO> getAll() {
        return productRepository.findAll().stream().map(productMapper::toResponse).toList();
    }

    public ProductResponseDTO getById(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if (product.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum produto com esse Id.");
        return productMapper.toResponse(product.get());
    }

    public ProductResponseDTO update(Long id, ProductRequestDTO productRequestDTO) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if (product.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum produto com esse Id.");
        ProductEntity productEntity = productMapper.toEntity(productRequestDTO);
        productEntity.setId(id);
        return productMapper.toResponse(productRepository.save(productEntity));
    }

    public ProductResponseDTO delete(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if (product.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum produto com esse Id.");
        productRepository.delete(product.get());
        return productMapper.toResponse(product.get());
    }
}
