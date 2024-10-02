package com.weslaine.projeto_intermediario.dtos;

import java.math.BigDecimal;

public record ProductResponseDTO(
        Long Id,
        String name,
        String description,
        BigDecimal price) {

}
