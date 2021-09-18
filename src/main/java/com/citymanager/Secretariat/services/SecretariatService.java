package com.citymanager.Secretariat.services;

import com.citymanager.Secretariat.dtos.CreateSecretariatDTO;
import com.citymanager.Secretariat.dtos.InvertigatedDTO;
import com.citymanager.Secretariat.entities.SecretariatEntity;
import com.citymanager.Secretariat.enums.FolderEnum;
import com.citymanager.Secretariat.repositories.SecretariatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecretariatService {

    private SecretariatRepository secretariatRepository;

    public SecretariatService(SecretariatRepository secretariatRepository) {
        this.secretariatRepository = secretariatRepository;
    }

    public SecretariatEntity create(CreateSecretariatDTO createSecretariatDto) {

        if(createSecretariatDto == null) return null; // TODO: exception dados de entrada inválidos

        FolderEnum folderDto = createSecretariatDto.getFolder();

        SecretariatEntity secretariat = secretariatRepository.findByFolder(folderDto);

        if(secretariat != null) return null; // TODO: exception ja possui secretaria cadastrada

        return secretariatRepository.save(createSecretariatDto.toEntity());
    }

    public List<SecretariatEntity> findAll() {
        return secretariatRepository.findAll();
    }

    public SecretariatEntity findById(Long id) {

        Optional<SecretariatEntity> secretariatOpt = secretariatRepository.findById(id);

        if(secretariatOpt.isEmpty()) return null; // TODO: exception notfound secretariat

        return secretariatOpt.get();
    }

    public void changeInvestigation(InvertigatedDTO invertigatedDTO, Long id) {

        if(invertigatedDTO == null) return; // TODO: exception objeto inválido! Envie um boolean

        Optional<SecretariatEntity> secretariatOpt = secretariatRepository.findById(id);

        if(secretariatOpt.isEmpty()) return; // TODO: exception secretaria notfound

        Boolean investigated = invertigatedDTO.getUnderInvestigation();
        SecretariatEntity secretariat = secretariatOpt.get();

        secretariat.setUnderInvestigation(investigated);

        secretariatRepository.save(secretariat);
    }
    
}
