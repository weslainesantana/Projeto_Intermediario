package com.weslaine.projeto_intermediario.services;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.weslaine.projeto_intermediario.dtos.AddressAndClientDto;
import com.weslaine.projeto_intermediario.dtos.AddressDto;
import com.weslaine.projeto_intermediario.dtos.ClientRequestDTO;
import com.weslaine.projeto_intermediario.dtos.ClientResponseDTO;
import com.weslaine.projeto_intermediario.mappers.ClientMapper;
import com.weslaine.projeto_intermediario.models.ClientEntity;
import com.weslaine.projeto_intermediario.repositories.ClientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientResponseDTO create(ClientRequestDTO clientRequestDTO) {
        return clientMapper.toDto(clientRepository.save(clientMapper.toEntity(clientRequestDTO)));
    }

    public AddressAndClientDto getClient(Long id) {

        Optional<ClientEntity> client = clientRepository.findById(id);
        if (client.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum cliente com este ID");
        ClientEntity clientEntity = client.get();
        CepService cepService = new CepService();

        AddressDto address = cepService.getAddress(clientEntity.getCep());
        if (address.getBairro() == null)
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Erro api fora do ar!");

        return clientMapper.toResponse(clientEntity, address);

    }

}
