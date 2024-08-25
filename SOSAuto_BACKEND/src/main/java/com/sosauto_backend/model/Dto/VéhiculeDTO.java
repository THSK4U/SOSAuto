package com.sosauto_backend.model.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class VéhiculeDTO {

    private Long véhiculeid;
    private String marque;
    private String modele;
    private int année;
    private String matricule;
    private String couleur;
    @JsonIgnore
    private AutomobilisteDTO automobiliste;

}
