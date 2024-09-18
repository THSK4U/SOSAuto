package com.sosauto_backend.model.Dto;

import com.sosauto_backend.model.Entity.DemandeDepannage;
import com.sosauto_backend.model.Entity.Mécanicien;
import com.sosauto_backend.model.Enum.StatutParticipation;
import lombok.Data;

@Data
public class ParticipationDTO {

        private Long id;
        private DemandeDepannage demande;
        private MécanicienDTO mecanicien;
        private StatutParticipation status;


}
