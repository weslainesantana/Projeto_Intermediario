package com.weslaine.projeto_intermediario.dtos;

import java.math.BigDecimal;

public record ProductResponseDTO(
                Long id,
                String name,
                String description,
                BigDecimal price) {

}
