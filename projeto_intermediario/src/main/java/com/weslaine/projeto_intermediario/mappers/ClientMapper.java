package com.weslaine.projeto_intermediario.mappers;

import org.mapstruct.Mapper;

import com.weslaine.projeto_intermediario.dtos.AddressAndClientDto;
import com.weslaine.projeto_intermediario.dtos.AddressDto;
import com.weslaine.projeto_intermediario.dtos.ClientRequestDTO;
import com.weslaine.projeto_intermediario.dtos.ClientResponseDTO;
import com.weslaine.projeto_intermediario.models.ClientEntity;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientResponseDTO toDto(ClientEntity clientEntity);

    AddressAndClientDto toResponse(ClientEntity clientEntity, AddressDto addressDto);

    ClientEntity toEntity(ClientRequestDTO clientRequestDTO);
}
