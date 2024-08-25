package com.sosauto_backend.service.Interface;

import com.sosauto_backend.model.Dto.AdministrateurDTO;

import java.util.List;

public interface IAdministrateurService {
    //Creer
    AdministrateurDTO creer(AdministrateurDTO personne);

    //mettre A Jour
    AdministrateurDTO mettreAJour(Long id, AdministrateurDTO DTO);

    //supprimer
    void supprimer(Long id);

    //consulter Tous
    List<AdministrateurDTO> voirTous();

    //By ID
    AdministrateurDTO getById(Long id);
}
