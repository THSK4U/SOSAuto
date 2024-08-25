package com.sosauto_backend.service.Interface;

import com.sosauto_backend.model.Dto.DemandeDepannageDTO;

import java.util.List;

public interface IDemandeService {
    //Creer
    DemandeDepannageDTO creer(DemandeDepannageDTO personne);

    //mettre A Jour
    DemandeDepannageDTO mettreAJour(Long id, DemandeDepannageDTO DTO);

    //supprimer
    void supprimer(Long id);

    //consulter Tous
    List<DemandeDepannageDTO> voirTous();

    //By ID
    DemandeDepannageDTO getById(Long id);
}