package com.sosauto_backend.service.Interface;

import com.sosauto_backend.model.Dto.DemandeDepannageDTO;

import java.util.List;

public interface IDemandeService {
    //Creer
    DemandeDepannageDTO creer(DemandeDepannageDTO personne);

    //mettre A Jour
    DemandeDepannageDTO mettreAJour(Long id, DemandeDepannageDTO dto);

    //supprimer
    void supprimer(Long id);

    //consulter Tous
    List<DemandeDepannageDTO> voirTous();

    //By ID
    DemandeDepannageDTO getById(Long id);

    //Get ALL By Automobiliste
    List<DemandeDepannageDTO> getALLByAutomobiliste(Long id);

    //Demande terminer
    DemandeDepannageDTO terminerDemande(Long demandeid);
}
