package com.sosauto_backend.controller;

import com.sosauto_backend.controller.api.IAdministrateurApi;
import com.sosauto_backend.model.dto.AdministrateurDTO;
import com.sosauto_backend.model.entity.AuthResponse;
import com.sosauto_backend.service.Interface.IAdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdministrateurController implements IAdministrateurApi {

    @Autowired
    private IAdministrateurService serviceadmin;

    @Override
    public AuthResponse creerAdministrateur(AdministrateurDTO administrateurDTO) {
        return serviceadmin.creer(administrateurDTO);
    }

    @Override
    public void supprimerAdministrateur(Long id) {
        serviceadmin.supprimer(id);
    }

    @Override
    public AdministrateurDTO mettreAJourAdministrateur(Long id, AdministrateurDTO administrateurDTO) {
        return serviceadmin.mettreAJour(id, administrateurDTO);
    }
}
