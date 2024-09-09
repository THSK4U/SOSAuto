package com.sosauto_backend.service.Interface;

import com.sosauto_backend.model.Dto.MécanicienDTO;
import com.sosauto_backend.model.Entity.AuthResponse;

import java.util.List;

public interface IMécanicienService {
    //Creer
    AuthResponse creer(MécanicienDTO personne);

    //mettre A Jour
    MécanicienDTO mettreAJour(Long id, MécanicienDTO DTO);

    //supprimer
    void supprimer(Long id);

    //consulter Tous
    List<MécanicienDTO> voirTous();

    //By ID
    MécanicienDTO getById(Long id);

    //mettre A Jour
    MécanicienDTO mettreAJourdisponibilite(Long id, MécanicienDTO DTO);

    //get Disponibilite
    List<MécanicienDTO> getDisponibilite();
}
