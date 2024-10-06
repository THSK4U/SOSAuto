package com.sosauto_backend.controller.api;


import com.sosauto_backend.model.dto.VehiculeDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sosauto_backend.utils.Constants.*;

public interface IVehiculeApi {

    //creer
    @PostMapping(value = APP_AUTO +"/Vehicule/Creer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VehiculeDTO creerVehicule(@RequestBody VehiculeDTO vehicule);

    //supprimer
    @DeleteMapping(value = APP_ADMIN_AUTO +"/Vehicule/Delete/{id}")
    void supprimerVehicule(@PathVariable("id") Long id);

    //Tous
    @GetMapping(value = APP_ADMIN + "/Vehicule", produces = MediaType.APPLICATION_JSON_VALUE)
    List<VehiculeDTO> getAllVehicule();

    //mettre A Jour
    @PutMapping(value =APP_ADMIN_AUTO + "/Vehicule/MettreAjour/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VehiculeDTO mettreAjourVehicule(@PathVariable("id") Long id, @RequestBody VehiculeDTO vehicule);

    //By id
    @GetMapping(value = APP_ADMIN_AUTO + "/Vehicule/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    VehiculeDTO getVehiculeById(@PathVariable("id") Long id);
}
