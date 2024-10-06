package com.sosauto_backend.service.Interface;

import com.sosauto_backend.model.dto.MecanicienDTO;
import com.sosauto_backend.model.entity.AuthResponse;

import java.util.List;

public interface IMecanicienService {
    //Creer
    AuthResponse creer(MecanicienDTO personne);

    //mettre A Jour
    MecanicienDTO mettreAJour(Long id, MecanicienDTO dto);

    //supprimer
    void supprimer(Long id);

    //consulter Tous
    List<MecanicienDTO> voirTous();

    //By ID
    MecanicienDTO getById(Long id);

    //mettre A Jour
    MecanicienDTO mettreAJourdisponibilite(Long id, MecanicienDTO dto);

    //get Disponibilite
    List<MecanicienDTO> getDisponibilite();

    //add Notation
    MecanicienDTO addNotation(Long mecanicienId, Double newRating);
}
