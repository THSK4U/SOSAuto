package com.sosauto_backend.model.Dto;

import com.sosauto_backend.model.Enum.EtatPanne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DemandeDepannageDTO {

    private Long panneid;
    private LocalDateTime dateTime;
    private Double latitude;
    private Double longitude;
    private EtatPanne etat;
    private AutomobilisteDTO automobiliste;
    private MécanicienDTO mécanicien;
    private PanneDTO panne;
}
