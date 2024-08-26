package com.sosauto_backend.controller.api;

import com.sosauto_backend.model.Dto.AutomobilisteDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IAutomobilisteApi {

    //creer
    @PostMapping(value = "/Automobiliste/Creer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AutomobilisteDTO creerAutomobiliste(@RequestBody AutomobilisteDTO automobiliste);

    //supprimer
    @DeleteMapping(value = "/Automobiliste/Delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void supprimerAutomobiliste(@PathVariable("id") Long id);

    //Tous
    @GetMapping(value = "/Automobiliste", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    List<AutomobilisteDTO> getAllAutomobiliste();

    //mettre A Jour
    @PutMapping(value = "/Automobiliste/MettreAjour/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AutomobilisteDTO mettreAjourAutomobiliste(@PathVariable("id") Long id,@RequestBody AutomobilisteDTO automobiliste);

    //By Id
    @GetMapping(value = "/utilisateur/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    AutomobilisteDTO getAutomobilisteById(@PathVariable("id") Long id);
}
