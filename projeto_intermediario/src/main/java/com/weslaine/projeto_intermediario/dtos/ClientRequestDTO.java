package com.weslaine.projeto_intermediario.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientRequestDTO(
        @NotBlank(message = "O campo nome não pode estar em branco.") String name,
        @NotBlank(message = "O campo cep não pode estar em branco.") String cep,
        @NotBlank(message = "O campo email não pode estar em branco") @Email String email) {

}
