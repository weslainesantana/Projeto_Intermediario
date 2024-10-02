package com.weslaine.projeto_intermediario.dtos;

import java.math.BigDecimal;

public record ProductRequestDTO(
        String name,
        String description,
        BigDecimal price) {

}
