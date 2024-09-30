package com.sosauto_backend.controller;

import com.sosauto_backend.controller.api.IAutomobilisteApi;
import com.sosauto_backend.model.Dto.AutomobilisteDTO;
import com.sosauto_backend.model.Entity.AuthResponse;
import com.sosauto_backend.service.AutomobilisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AutomobilisteController implements IAutomobilisteApi {

    @Autowired
    private AutomobilisteService ServiceAuto;

    @Override
    public AuthResponse creerAutomobiliste(AutomobilisteDTO automobiliste) {
        return ServiceAuto.creer(automobiliste);
    }

    @Override
    public void supprimerAutomobiliste(Long id) {
        ServiceAuto.supprimer(id);
    }

    @Override
    public List<AutomobilisteDTO> getAllAutomobiliste() {
        return ServiceAuto.voirTous();
    }

    @Override
    public AutomobilisteDTO mettreAjourAutomobiliste(Long id, AutomobilisteDTO automobiliste) {
        return ServiceAuto.mettreAJour(id, automobiliste);
    }

    @Override
    public AutomobilisteDTO getAutomobilisteById(Long id) {
        return ServiceAuto.getById(id);
    }
}
