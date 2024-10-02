package com.weslaine.projeto_intermediario.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weslaine.projeto_intermediario.models.EstudanteEntity;

@RestController
@RequestMapping("sobre")
public class EstudanteController {
    @GetMapping
    public EstudanteEntity getEstudante() {
        EstudanteEntity estudanteEntity = new EstudanteEntity();
        return estudanteEntity;
    }

}
