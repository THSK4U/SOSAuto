package com.sosauto_backend.controller;

import com.sosauto_backend.controller.api.IVéhiculeApi;
import com.sosauto_backend.model.Dto.VéhiculeDTO;
import com.sosauto_backend.service.VéhiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VéhiculeController implements IVéhiculeApi {

    @Autowired
    private VéhiculeService Service;

    @Override
    public VéhiculeDTO creerVehicule(VéhiculeDTO vehicule) {
        return Service.creer(vehicule);
    }

    @Override
    public void supprimerVehicule(Long id) {
        Service.supprimer(id);
    }

    @Override
    public List<VéhiculeDTO> getAllVehicule() {
        return Service.voirTous();
    }

    @Override
    public VéhiculeDTO mettreAjourVehicule(Long id, VéhiculeDTO vehicule) {
        return Service.mettreAJour(id, vehicule);
    }

    @Override
    public VéhiculeDTO getVehiculeById(Long id) {
        return Service.getById(id);
    }
}
