package com.citymanager.Secretariat.dtos;

import lombok.Data;

@Data
public class CreateSecretariatDTO {

    private String folder;
    private String secretary;
    private Float populationGrade;
    private Float underInvestigation;
}
