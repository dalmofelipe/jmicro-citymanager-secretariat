package com.citymanager.Secretariat.controllers;

import java.util.List;

import com.citymanager.Secretariat.dtos.InvertigatedDTO;
import com.citymanager.Secretariat.dtos.CreateSecretariatDTO;
import com.citymanager.Secretariat.entities.SecretariatEntity;
import com.citymanager.Secretariat.services.SecretariatService;

import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import javax.validation.Valid;

@RestController
@RequestMapping("/secretariats")
@AllArgsConstructor
public class SecretariatController {

    private final SecretariatService secretariatService;

    // Cria uma secretaria, validando se já existe uma com a mesma pasta e os demais campos que não devem ser nulos ou brancos.
    @PostMapping
    public SecretariatEntity create(@Valid @RequestBody CreateSecretariatDTO createSecretariatDto) {
        return secretariatService.create(createSecretariatDto);
    }

    // Lista todas as secretarias
    @GetMapping
    public List<SecretariatEntity> listSecretariat() {
        return secretariatService.findAll();
    }

    // Busca uma secretaria pelo id
    @GetMapping("/{id}")
    public SecretariatEntity findSecretariat(@PathVariable Long id) {
        return secretariatService.findById(id);
    }

    // Altera o atributo underInvestigation.
    @PatchMapping("/{id}/investigation")
    public void changeInvestigation(@Valid @RequestBody InvertigatedDTO invertigatedDTO, @PathVariable Long id) {
        secretariatService.changeInvestigation(invertigatedDTO, id);
    }

}
