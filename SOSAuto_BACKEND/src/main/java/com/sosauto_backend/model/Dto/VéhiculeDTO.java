package com.sosauto_backend.model.Dto;

import lombok.Data;

@Data
public class VéhiculeDTO {

    private int véhiculeid;
    private String marque;
    private String modele;
    private int année;
    private String matricule;
    private String couleur;
    private AutomobilisteDTO automobiliste;

}
