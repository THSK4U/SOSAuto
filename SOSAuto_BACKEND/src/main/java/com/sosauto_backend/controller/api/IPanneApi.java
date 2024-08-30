package com.sosauto_backend.controller.api;


import com.sosauto_backend.model.Dto.PanneDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IPanneApi {

    //creer
    @PostMapping(value = "/Panne/Creer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PanneDTO creerPanne(@RequestBody PanneDTO panne);

    //supprimer
    @DeleteMapping(value = "/Panne/Delete/{id}")
    void supprimerPanne(@PathVariable("id") Long id);

    //Tous
    @GetMapping(value = "/Panne", produces = MediaType.APPLICATION_JSON_VALUE)
    List<PanneDTO> getAllPanne();

    //mettre A Jour
    @PutMapping(value = "/Panne/MettreAjour/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PanneDTO mettreAjourPanne(@PathVariable("id") Long id,@RequestBody PanneDTO panne);

    //By id
    @GetMapping(value = "/Panne/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    PanneDTO getPanneById(@PathVariable("id") Long id);
}
