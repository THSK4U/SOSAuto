package com.sosauto_backend.controller;

import com.sosauto_backend.controller.api.IDemandeApi;
import com.sosauto_backend.model.dto.DemandeDepannageDTO;
import com.sosauto_backend.service.Interface.IDemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemandeController implements IDemandeApi {

    @Autowired
    private IDemandeService service;

    @Override
    public DemandeDepannageDTO creerDemande(DemandeDepannageDTO demande) {
        return service.creer(demande);
    }

    @Override
    public void supprimerDemande(Long id) {
    service.supprimer(id);
    }

    @Override
    public List<DemandeDepannageDTO> getAllDemande() {
        return service.voirTous();
    }

    @Override
    public DemandeDepannageDTO mettreAjourDemande(Long id, DemandeDepannageDTO demande) {
        return service.mettreAJour(id,demande);
    }

    @Override
    public DemandeDepannageDTO getDemandeById(Long id) {
        return service.getById(id);
    }

    @Override
    public List<DemandeDepannageDTO> getAllDemandeByAutomobiliste(Long id) {
        return service.getALLByAutomobiliste(id);
    }

    @Override
    public DemandeDepannageDTO terminerDemande(Long demandeid) {
        return service.terminerDemande(demandeid);
    }
}
