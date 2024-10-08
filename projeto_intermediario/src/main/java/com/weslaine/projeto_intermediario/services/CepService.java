package com.weslaine.projeto_intermediario.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.net.URI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weslaine.projeto_intermediario.dtos.AddressDto;

@Service
public class CepService {
    AddressDto addressDto = new AddressDto();

    public AddressDto getAddress(String cep) {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json/")).build();
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if (httpResponse.statusCode() != 200)
                throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Api forado ar!");
            ObjectMapper objectMapper = new ObjectMapper();
            addressDto = objectMapper.readValue(httpResponse.body(), AddressDto.class);

        } catch (Exception e) {
            System.out.println(e);
        }
        return addressDto;
    }
}
