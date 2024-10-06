package com.sosauto_backend.service.Interface;


import com.sosauto_backend.model.dto.ParticipationDTO;

import java.util.List;

public interface IParticipationService {
    //Creer
    ParticipationDTO creer(ParticipationDTO participation);

    //mettre A Jour
    ParticipationDTO mettreAJour(Long id, ParticipationDTO dto);

    //supprimer
    void supprimer(Long id);

    //supprimer BY Demande Id
    void supprimerByDemande(Long demandeId, Long mecanicienid);

    //consulter Tous
    List<ParticipationDTO> voirTous();

    //By ID
    ParticipationDTO getById(Long id);

    //By ID Mecanicien
    List<ParticipationDTO> getByMecanicienId(Long id);

    //By ID Demande.AutomobilistId
    List<ParticipationDTO> getByDemande_AutomobilistId(Long id);

    //All By Demande Id
    List<ParticipationDTO> getALLByDemandeID(Long id);

    //Accept ou reject
    ParticipationDTO acceptParticipation(Long participationid);
    ParticipationDTO rejectParticipation(Long participationid);

    //Annuler Participation
    ParticipationDTO annulerParticipation(Long participationid);

}
