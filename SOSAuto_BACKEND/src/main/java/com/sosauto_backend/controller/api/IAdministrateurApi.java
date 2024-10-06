package com.sosauto_backend.controller.api;

import com.sosauto_backend.model.dto.AdministrateurDTO;
import com.sosauto_backend.model.entity.AuthResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.sosauto_backend.utils.Constants.APP_ADMIN;

public interface IAdministrateurApi {
    @PostMapping(value = APP_ADMIN + "/Administrateur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AuthResponse creerAdministrateur(@RequestBody AdministrateurDTO administrateurDTO);

    @DeleteMapping(value = APP_ADMIN + "/Administrateur/delete/{id}")
    void supprimerAdministrateur(@PathVariable("id") Long id);

    @PutMapping(value = APP_ADMIN + "/Administrateur/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AdministrateurDTO mettreAJourAdministrateur(@PathVariable("id") Long id, @RequestBody AdministrateurDTO administrateurDTO);
}