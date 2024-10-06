package com.sosauto_backend.model.dto;

import com.sosauto_backend.model.entity.DemandeDepannage;
import com.sosauto_backend.model.enums.StatutParticipation;
import lombok.Data;

@Data
public class ParticipationDTO {

        private Long id;
        private DemandeDepannage demande;
        private MecanicienDTO mecanicien;
        private StatutParticipation status;


}
