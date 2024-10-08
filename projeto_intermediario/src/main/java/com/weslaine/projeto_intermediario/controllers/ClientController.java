package com.weslaine.projeto_intermediario.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.weslaine.projeto_intermediario.dtos.AddressAndClientDto;
import com.weslaine.projeto_intermediario.dtos.ClientRequestDTO;
import com.weslaine.projeto_intermediario.dtos.ClientResponseDTO;
import com.weslaine.projeto_intermediario.services.ClientService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponseDTO create(@RequestBody @Valid ClientRequestDTO clientRequestDTO) {
        return clientService.create(clientRequestDTO);
    }

    @GetMapping("/{id}")
    public AddressAndClientDto getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }
}
