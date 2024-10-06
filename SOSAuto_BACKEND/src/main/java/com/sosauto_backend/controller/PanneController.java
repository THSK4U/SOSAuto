package com.sosauto_backend.controller;

import com.sosauto_backend.controller.api.IPanneApi;
import com.sosauto_backend.model.dto.PanneDTO;
import com.sosauto_backend.service.PanneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PanneController implements IPanneApi {

    @Autowired
    private PanneService service;

    @Override
    public PanneDTO creerPanne(PanneDTO panne) {
        return service.creer(panne);
    }

    @Override
    public void supprimerPanne(Long id) {
        service.supprimer(id);
    }

    @Override
    public List<PanneDTO> getAllPanne() {
        return service.voirTous();
    }

    @Override
    public PanneDTO mettreAjourPanne(Long id, PanneDTO panne) {
        return service.mettreAJour(id, panne);
    }

    @Override
    public PanneDTO getPanneById(Long id) {
        return service.getById(id);
    }
}
