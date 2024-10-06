package com.sosauto_backend.service.Interface;

import com.sosauto_backend.model.dto.AdministrateurDTO;
import com.sosauto_backend.model.entity.AuthResponse;

import java.util.List;

public interface IAdministrateurService {
    //Creer
    AuthResponse creer(AdministrateurDTO personne);

    //mettre A Jour
    AdministrateurDTO mettreAJour(Long id, AdministrateurDTO dto);

    //supprimer
    void supprimer(Long id);

    //consulter Tous
    List<AdministrateurDTO> voirTous();

    //By ID
    AdministrateurDTO getById(Long id);
}
