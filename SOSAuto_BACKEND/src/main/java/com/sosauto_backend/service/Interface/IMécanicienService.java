package com.sosauto_backend.service.Interface;

import com.sosauto_backend.model.Dto.MécanicienDTO;

import java.util.List;

public interface IMécanicienService {
    //Creer
    MécanicienDTO creer(MécanicienDTO personne);

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
}
