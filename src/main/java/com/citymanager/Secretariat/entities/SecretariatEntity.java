package com.citymanager.Secretariat.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.citymanager.Secretariat.enums.FolderEnum;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_secretariat")
public class SecretariatEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private FolderEnum folder;

    private String secretary;

    @Column(name = "poputation_grade")
    private Float populationGrade;

    @Column(name = "under_investigation")
    private Boolean underInvestigation;
    
}
