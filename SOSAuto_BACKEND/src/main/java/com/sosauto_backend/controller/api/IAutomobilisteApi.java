package com.sosauto_backend.controller.api;

import com.sosauto_backend.model.Dto.AutomobilisteDTO;
import com.sosauto_backend.model.Entity.AuthResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sosauto_backend.utils.Constants.*;

public interface IAutomobilisteApi {

    //creer
    @PostMapping(value = APP_PERMIT_ALL + "/Automobiliste/Creer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AuthResponse creerAutomobiliste(@RequestBody AutomobilisteDTO automobiliste);

    //supprimer
    @DeleteMapping(value = APP_AUTO + "/Automobiliste/Delete/{id}")
    void supprimerAutomobiliste(@PathVariable("id") Long id);

    //Tous
    @GetMapping(value = APP_ADMIN + "/Automobiliste", produces = MediaType.APPLICATION_JSON_VALUE)
    List<AutomobilisteDTO> getAllAutomobiliste();

    //mettre A Jour
    @PutMapping(value = APP_ADMIN_AUTO + "/Automobiliste/MettreAjour/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AutomobilisteDTO mettreAjourAutomobiliste(@PathVariable("id") Long id,@RequestBody AutomobilisteDTO automobiliste);

    //By id
    @GetMapping(value = APP_ADMIN_AUTO + "/Automobiliste/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    AutomobilisteDTO getAutomobilisteById(@PathVariable("id") Long id);
}
