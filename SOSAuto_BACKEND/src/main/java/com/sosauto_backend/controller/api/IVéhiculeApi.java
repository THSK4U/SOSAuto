package com.sosauto_backend.controller.api;


import com.sosauto_backend.model.Dto.VéhiculeDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IVéhiculeApi {

    //creer
    @PostMapping(value = "/Vehicule/Creer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VéhiculeDTO creerPanne(@RequestBody VéhiculeDTO vehicule);

    //supprimer
    @DeleteMapping(value = "/Vehicule/Delete/{id}")
    void supprimerPanne(@PathVariable("id") Long id);

    //Tous
    @GetMapping(value = "/Vehicule", produces = MediaType.APPLICATION_JSON_VALUE)
    List<VéhiculeDTO> getAllPanne();

    //mettre A Jour
    @PutMapping(value = "/Vehicule/MettreAjour/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VéhiculeDTO mettreAjourPanne(@PathVariable("id") Long id,@RequestBody VéhiculeDTO vehicule);

    //By id
    @GetMapping(value = "/Vehicule/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    VéhiculeDTO getPanneById(@PathVariable("id") Long id);
}
