package com.sosauto_backend.controller;


import com.sosauto_backend.controller.api.IMécanicienApi;
import com.sosauto_backend.model.Dto.MécanicienDTO;
import com.sosauto_backend.service.Interface.IMécanicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MécanicienController implements IMécanicienApi {

    @Autowired
    private IMécanicienService service;

    @Override
    public MécanicienDTO creerMécanicien(MécanicienDTO Mécanicien) {
        return service.creer(Mécanicien);
    }

    @Override
    public void supprimerMécanicien(Long id) {
        service.supprimer(id);
    }

    @Override
    public List<MécanicienDTO> getAllMécanicien() {
        System.out.println("getAllMécanicien"+ service.voirTous());
        return service.voirTous();
    }

    @Override
    public MécanicienDTO mettreAjourMécanicien(Long id, MécanicienDTO mécanicien) {
        return service.mettreAJour(id,mécanicien);
    }

    @Override
    public MécanicienDTO getMécanicienById(Long id) {
        return service.getById(id);
    }

    @Override
    public MécanicienDTO mettreAjourDisponibilite(Long id, MécanicienDTO mécanicien) {
        return service.mettreAJourdisponibilite(id,mécanicien);
    }

    @Override
    public List<MécanicienDTO> getAllMécanicienDesponible() {
        return service.getDisponibilite();
    }
}

