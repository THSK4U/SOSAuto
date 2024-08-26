package com.sosauto_backend.controller.api;

import com.sosauto_backend.model.Dto.AdministrateurDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

public interface IAdministrateurApi {
    @PostMapping(value =  "/Administrateur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AdministrateurDTO creerAdministrateur(@RequestBody AdministrateurDTO administrateurDTO);

    @DeleteMapping(value =  "/Administrateur/delete/{id}")
    void supprimerAdministrateur(@PathVariable("id") Long id);

    @PutMapping(value = "/Administrateur/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AdministrateurDTO mettreAJourAdministrateur(@PathVariable("id") Long id, @RequestBody AdministrateurDTO administrateurDTO);
}