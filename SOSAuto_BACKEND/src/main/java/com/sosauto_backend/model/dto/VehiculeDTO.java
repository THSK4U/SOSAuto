package com.sosauto_backend.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class VehiculeDTO {

    private Long vehiculeid;
    private String marque;
    private String modele;
    private int annee;
    private String matricule;
    private String couleur;
    @JsonIgnore
    private AutomobilisteDTO automobiliste;

}
