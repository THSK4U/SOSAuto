package com.sosauto_backend.service.Interface;

import com.sosauto_backend.model.Dto.AutomobilisteDTO;

import java.util.List;

public interface IAutomobilisteService {
    //Creer
    AutomobilisteDTO creer(AutomobilisteDTO personne);

    //mettre A Jour
    AutomobilisteDTO mettreAJour(Long id, AutomobilisteDTO DTO);

    //supprimer
    void supprimer(Long id);

    //consulter Tous
    List<AutomobilisteDTO> voirTous();

    //By ID
    AutomobilisteDTO getById(Long id);
}
