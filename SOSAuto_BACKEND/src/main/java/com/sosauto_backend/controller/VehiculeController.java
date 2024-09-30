package com.sosauto_backend.controller;

import com.sosauto_backend.controller.api.IVéhiculeApi;
import com.sosauto_backend.model.Dto.VehiculeDTO;
import com.sosauto_backend.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehiculeController implements IVéhiculeApi {

    @Autowired
    private VehiculeService Service;

    @Override
    public VehiculeDTO creerVehicule(VehiculeDTO vehicule) {
        return Service.creer(vehicule);
    }

    @Override
    public void supprimerVehicule(Long id) {
        Service.supprimer(id);
    }

    @Override
    public List<VehiculeDTO> getAllVehicule() {
        return Service.voirTous();
    }

    @Override
    public VehiculeDTO mettreAjourVehicule(Long id, VehiculeDTO vehicule) {
        return Service.mettreAJour(id, vehicule);
    }

    @Override
    public VehiculeDTO getVehiculeById(Long id) {
        return Service.getById(id);
    }
}
