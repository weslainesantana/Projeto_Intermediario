package com.weslaine.projeto_intermediario.mappers;

import org.mapstruct.Mapper;

import com.weslaine.projeto_intermediario.dtos.ProductRequestDTO;
import com.weslaine.projeto_intermediario.dtos.ProductResponseDTO;
import com.weslaine.projeto_intermediario.models.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductRequestDTO toCreate(ProductEntity productEntity);

    ProductResponseDTO toResponse(ProductEntity productEntity);

    ProductEntity toEntity(ProductRequestDTO productRequestDTO);
}