package com.sosauto_backend.controller;

import com.sosauto_backend.controller.api.IAdministrateurApi;
import com.sosauto_backend.model.Dto.AdministrateurDTO;
import com.sosauto_backend.model.Entity.AuthResponse;
import com.sosauto_backend.service.Interface.IAdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdministrateurController implements IAdministrateurApi {

    @Autowired
    private IAdministrateurService ServiceAdmin;

    @Override
    public AuthResponse creerAdministrateur(AdministrateurDTO administrateurDTO) {
        return ServiceAdmin.creer(administrateurDTO);
    }

    @Override
    public void supprimerAdministrateur(Long id) {
        ServiceAdmin.supprimer(id);
    }

    @Override
    public AdministrateurDTO mettreAJourAdministrateur(Long id, AdministrateurDTO administrateurDTO) {
        return ServiceAdmin.mettreAJour(id, administrateurDTO);
    }
}
