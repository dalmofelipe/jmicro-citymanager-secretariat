package com.citymanager.Secretariat.controllers;

import java.util.List;

import com.citymanager.Secretariat.dtos.ChangeInvestigationSecretariatDto;
import com.citymanager.Secretariat.dtos.CreateSecretariatDTO;
import com.citymanager.Secretariat.entities.SecretariatEntity;
import com.citymanager.Secretariat.services.SecretariatService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/secretariats")
@AllArgsConstructor
public class SecretariatController {

    private final SecretariatService secretariatService;

    // Cria uma secretaria, validando se já existe uma com a mesma pasta e os demais campos que não devem ser nulos ou brancos.
    @PostMapping
    public SecretariatEntity create(@RequestBody CreateSecretariatDTO createSecretariatDto) {
        return secretariatService.create(createSecretariatDto);
    }

    // Lista todas as secretarias
    @GetMapping
    public List<SecretariatEntity> listSecretariat() {
        return secretariatService.findAll();
    }

    // Busca uma secretaria pelo id
    @GetMapping("/secretariats/{id}")
    public SecretariatEntity findSecretariat(@RequestParam Long id) {
        return secretariatService.findById(id);
    }

    // Altera o atributo underInvestigation.
    @PatchMapping("/secretariats/{id}/investigation")
    public void changeInvestigation(@RequestBody ChangeInvestigationSecretariatDto changeInvestigationSecretariatDto) {
        secretariatService.changeInvestigation(changeInvestigationSecretariatDto);
    }

}
