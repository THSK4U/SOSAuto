package com.sosauto_backend.service.Interface;


import com.sosauto_backend.model.Dto.ParticipationDTO;

import java.util.List;

public interface IParticipationService {
    //Creer
    ParticipationDTO creer(ParticipationDTO participation);

    //mettre A Jour
    ParticipationDTO mettreAJour(Long id, ParticipationDTO DTO);

    //supprimer
    void supprimer(Long id);

    //supprimer BY Demande Id
    void supprimerByDemande(Long demandeId, Long mecanicienId);

    //consulter Tous
    List<ParticipationDTO> voirTous();

    //By ID
    ParticipationDTO getById(Long id);

    //By ID Mecanicien
    List<ParticipationDTO> getByMecanicienId(Long id);

    //Accept ou reject
    ParticipationDTO acceptParticipation(Long participationId);
    ParticipationDTO rejectParticipation(Long participationId);
}
