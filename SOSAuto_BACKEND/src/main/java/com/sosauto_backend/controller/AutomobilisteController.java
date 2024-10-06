package com.sosauto_backend.controller;

import com.sosauto_backend.controller.api.IAutomobilisteApi;
import com.sosauto_backend.model.dto.AutomobilisteDTO;
import com.sosauto_backend.model.entity.AuthResponse;
import com.sosauto_backend.service.AutomobilisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AutomobilisteController implements IAutomobilisteApi {

    @Autowired
    private AutomobilisteService serviceauto;

    @Override
    public AuthResponse creerAutomobiliste(AutomobilisteDTO automobiliste) {
        return serviceauto.creer(automobiliste);
    }

    @Override
    public void supprimerAutomobiliste(Long id) {
        serviceauto.supprimer(id);
    }

    @Override
    public List<AutomobilisteDTO> getAllAutomobiliste() {
        return serviceauto.voirTous();
    }

    @Override
    public AutomobilisteDTO mettreAjourAutomobiliste(Long id, AutomobilisteDTO automobiliste) {
        return serviceauto.mettreAJour(id, automobiliste);
    }

    @Override
    public AutomobilisteDTO getAutomobilisteById(Long id) {
        return serviceauto.getById(id);
    }
}
