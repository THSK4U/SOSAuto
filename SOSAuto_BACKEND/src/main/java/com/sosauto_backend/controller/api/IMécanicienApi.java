package com.sosauto_backend.controller.api;


import com.sosauto_backend.model.Dto.MécanicienDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IMécanicienApi {

    //creer
    @PostMapping(value = "/Mecanicien/Creer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MécanicienDTO creerMécanicien(@RequestBody MécanicienDTO mécanicien);

    //supprimer
    @DeleteMapping(value = "/Mecanicien/Delete/{id}")
    void supprimerMécanicien(@PathVariable("id") Long id);

    //Tous
    @GetMapping(value = "/Mecanicien", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MécanicienDTO> getAllMécanicien();

    //mettre A Jour
    @PutMapping(value = "/Mecanicien/MettreAjour/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MécanicienDTO mettreAjourMécanicien(@PathVariable("id") Long id,@RequestBody MécanicienDTO mécanicien);

    //By id
    @GetMapping(value = "/Mecanicien/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    MécanicienDTO getMécanicienById(@PathVariable("id") Long id);

    //mettre A Jour Disponibilite
    @PutMapping(value = "/Mecanicien/MettreAjour/{id}/Disponibilite", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MécanicienDTO mettreAjourDisponibilite(@PathVariable("id") Long id,@RequestBody MécanicienDTO mécanicien);

}
