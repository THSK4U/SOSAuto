package com.sosauto_backend.service.Interface;

import com.sosauto_backend.model.Dto.MecanicienDTO;
import com.sosauto_backend.model.Entity.AuthResponse;

import java.util.List;

public interface IMecanicienService {
    //Creer
    AuthResponse creer(MecanicienDTO personne);

    //mettre A Jour
    MecanicienDTO mettreAJour(Long id, MecanicienDTO DTO);

    //supprimer
    void supprimer(Long id);

    //consulter Tous
    List<MecanicienDTO> voirTous();

    //By ID
    MecanicienDTO getById(Long id);

    //mettre A Jour
    MecanicienDTO mettreAJourdisponibilite(Long id, MecanicienDTO DTO);

    //get Disponibilite
    List<MecanicienDTO> getDisponibilite();
}
