package com.sosauto_backend.controller;


import com.sosauto_backend.controller.api.IMecanicienApi;
import com.sosauto_backend.model.Dto.MecanicienDTO;
import com.sosauto_backend.model.Entity.AuthResponse;
import com.sosauto_backend.service.Interface.IMecanicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MecanicienController implements IMecanicienApi {

    @Autowired
    private IMecanicienService service;

    @Override
    public AuthResponse creerMecanicien(MecanicienDTO mecanicien) {
        return service.creer(mecanicien);
    }

    @Override
    public void supprimerMecanicien(Long id) {
        service.supprimer(id);
    }

    @Override
    public List<MecanicienDTO> getAllMecanicien() {
        return service.voirTous();
    }

    @Override
    public MecanicienDTO mettreAjourMecanicien(Long id, MecanicienDTO mecanicien) {
        return service.mettreAJour(id,mecanicien);
    }

    @Override
    public MecanicienDTO getMecanicienById(Long id) {
        return service.getById(id);
    }

    @Override
    public MecanicienDTO mettreAjourDisponibilite(Long id, MecanicienDTO mecanicien) {
        return service.mettreAJourdisponibilite(id,mecanicien);
    }

    @Override
    public List<MecanicienDTO> getAllMecanicienDesponible() {
        return service.getDisponibilite();
    }
}

