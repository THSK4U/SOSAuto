package com.sosauto_backend.controller;

import com.sosauto_backend.controller.api.IPanneApi;
import com.sosauto_backend.model.Dto.PanneDTO;
import com.sosauto_backend.service.PanneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PanneController implements IPanneApi {

    @Autowired
    private PanneService Service;

    @Override
    public PanneDTO creerPanne(PanneDTO panne) {
        return Service.creer(panne);
    }

    @Override
    public void supprimerPanne(Long id) {
        Service.supprimer(id);
    }

    @Override
    public List<PanneDTO> getAllPanne() {
        return Service.voirTous();
    }

    @Override
    public PanneDTO mettreAjourPanne(Long id, PanneDTO panne) {
        return Service.mettreAJour(id, panne);
    }

    @Override
    public PanneDTO getPanneById(Long id) {
        return Service.getById(id);
    }
}
