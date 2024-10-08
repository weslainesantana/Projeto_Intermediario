package com.weslaine.projeto_intermediario.dtos;

public record AddressAndClientDto(
                Long id,
                String name,
                String cep,
                String email,
                String logradouro,
                String complemento,
                String bairro,
                String localidade,
                String uf,
                String ibge,
                String gia,
                String ddd,
                String siafi) {

}
