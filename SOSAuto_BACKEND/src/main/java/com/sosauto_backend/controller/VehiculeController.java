package com.sosauto_backend.controller;

import com.sosauto_backend.controller.api.IVehiculeApi;
import com.sosauto_backend.model.dto.VehiculeDTO;
import com.sosauto_backend.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehiculeController implements IVehiculeApi {

    @Autowired
    private VehiculeService service;

    @Override
    public VehiculeDTO creerVehicule(VehiculeDTO vehicule) {
        return service.creer(vehicule);
    }

    @Override
    public void supprimerVehicule(Long id) {
        service.supprimer(id);
    }

    @Override
    public List<VehiculeDTO> getAllVehicule() {
        return service.voirTous();
    }

    @Override
    public VehiculeDTO mettreAjourVehicule(Long id, VehiculeDTO vehicule) {
        return service.mettreAJour(id, vehicule);
    }

    @Override
    public VehiculeDTO getVehiculeById(Long id) {
        return service.getById(id);
    }
}
