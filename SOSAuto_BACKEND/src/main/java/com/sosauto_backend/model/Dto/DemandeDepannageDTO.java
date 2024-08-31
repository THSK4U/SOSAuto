package com.sosauto_backend.model.Dto;

import com.sosauto_backend.model.Entity.Automobiliste;
import com.sosauto_backend.model.Entity.Mécanicien;
import com.sosauto_backend.model.Entity.Panne;
import com.sosauto_backend.model.Enum.EtatPanne;
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
    private Automobiliste automobiliste;
    private Mécanicien mécanicien;
    private Panne panne;
}
