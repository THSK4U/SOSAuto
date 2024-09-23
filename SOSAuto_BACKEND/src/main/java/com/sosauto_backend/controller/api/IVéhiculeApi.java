package com.sosauto_backend.controller.api;


import com.sosauto_backend.model.Dto.VéhiculeDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sosauto_backend.utils.Constants.*;

public interface IVéhiculeApi {

    //creer
    @PostMapping(value = APP_AUTO +"/Vehicule/Creer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VéhiculeDTO creerVehicule(@RequestBody VéhiculeDTO vehicule);

    //supprimer
    @DeleteMapping(value = APP_ADMIN_AUTO +"/Vehicule/Delete/{id}")
    void supprimerVehicule(@PathVariable("id") Long id);

    //Tous
    @GetMapping(value = APP_ADMIN + "/Vehicule", produces = MediaType.APPLICATION_JSON_VALUE)
    List<VéhiculeDTO> getAllVehicule();

    //mettre A Jour
    @PutMapping(value =APP_ADMIN_AUTO + "/Vehicule/MettreAjour/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VéhiculeDTO mettreAjourVehicule(@PathVariable("id") Long id,@RequestBody VéhiculeDTO vehicule);

    //By id
    @GetMapping(value = APP_ADMIN_AUTO + "/Vehicule/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    VéhiculeDTO getVehiculeById(@PathVariable("id") Long id);
}
