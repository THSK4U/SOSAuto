package com.sosauto_backend.controller;

import com.sosauto_backend.controller.api.IAdministrateurApi;
import com.sosauto_backend.model.Dto.AdministrateurDTO;
import com.sosauto_backend.service.Interface.IAdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdministrateurController implements IAdministrateurApi {

    @Autowired
    private IAdministrateurService Service;

    @Override
    public AdministrateurDTO creerAdministrateur(AdministrateurDTO administrateurDTO) {
        return Service.creer(administrateurDTO);
    }

    @Override
    public void supprimerAdministrateur(Long id) {
        Service.supprimer(id);
    }

    @Override
    public AdministrateurDTO mettreAJourAdministrateur(Long id, AdministrateurDTO administrateurDTO) {
        return Service.mettreAJour(id, administrateurDTO);
    }
}
