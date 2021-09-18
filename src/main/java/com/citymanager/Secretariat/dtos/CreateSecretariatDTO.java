package com.citymanager.Secretariat.dtos;

import com.citymanager.Secretariat.entities.SecretariatEntity;
import com.citymanager.Secretariat.enums.FolderEnum;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateSecretariatDTO {

    @NotNull
    private FolderEnum folder;

    @NotBlank
    @NotNull
    private String secretary;

    @NotNull
    @Min(0) @Max(100)
    private Float populationGrade;

    @NotNull
    private Boolean underInvestigation;

    public SecretariatEntity toEntity() {
        SecretariatEntity secretariat = new SecretariatEntity();
        BeanUtils.copyProperties(this, secretariat);
        return secretariat;
    }
}
