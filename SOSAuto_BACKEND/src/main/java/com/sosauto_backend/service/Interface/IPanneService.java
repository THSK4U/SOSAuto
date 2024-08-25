package com.sosauto_backend.service.Interface;

import com.sosauto_backend.model.Dto.PanneDTO;

import java.util.List;

public interface IPanneService {
    //Creer
    PanneDTO creer(PanneDTO personne);

    //mettre A Jour
    PanneDTO mettreAJour(Long id, PanneDTO DTO);

    //supprimer
    void supprimer(Long id);

    //consulter Tous
    List<PanneDTO> voirTous();

    //By ID
    PanneDTO getById(Long id);
}
