package com.sosauto_backend.controller;

import com.sosauto_backend.controller.api.IAutomobilisteApi;
import com.sosauto_backend.model.Dto.AutomobilisteDTO;
import com.sosauto_backend.model.Entity.AuthResponse;
import com.sosauto_backend.service.AutomobilisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AutomobilisteController implements IAutomobilisteApi {

    @Autowired
    private AutomobilisteService Service;

    @Override
    public AuthResponse creerAutomobiliste(AutomobilisteDTO automobiliste) {
        return Service.creer(automobiliste);
    }

    @Override
    public void supprimerAutomobiliste(Long id) {
     Service.supprimer(id);
    }

    @Override
    public List<AutomobilisteDTO> getAllAutomobiliste() {
        return Service.voirTous();
    }

    @Override
    public AutomobilisteDTO mettreAjourAutomobiliste(Long id, AutomobilisteDTO automobiliste) {
        return Service.mettreAJour(id, automobiliste);
    }

    @Override
    public AutomobilisteDTO getAutomobilisteById(Long id) {
        return Service.getById(id);
    }
}
