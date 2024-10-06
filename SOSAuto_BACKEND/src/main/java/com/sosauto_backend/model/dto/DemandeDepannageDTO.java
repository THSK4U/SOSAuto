package com.sosauto_backend.model.dto;

import com.sosauto_backend.model.entity.Mecanicien;
import com.sosauto_backend.model.entity.Panne;
import com.sosauto_backend.model.enums.EtatPanne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DemandeDepannageDTO {

    private Long demandeid;
    private LocalDateTime dateTime;
    private Double latitude;
    private Double longitude;
    private String description;
    private EtatPanne etat;
    private AutomobilisteDTO automobiliste;
    private Mecanicien mecanicien;
    private Panne panne;
}
