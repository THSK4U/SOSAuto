package com.sosauto_backend.controller.api;

import com.sosauto_backend.model.Dto.AdministrateurDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

public interface IAdministrateurApi {
    @PostMapping(value =  "/Administrateur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AdministrateurDTO createAdministrateur(@RequestBody AdministrateurDTO administrateurDTO);

    @DeleteMapping(value =  "/Administrateur/delete/{id}")
    void deleteAdministrateur(@PathVariable("id") Long id);

    @PutMapping(value = "/Administrateur/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AdministrateurDTO updateAdministrateur(@PathVariable("id") Long id, @RequestBody AdministrateurDTO administrateurDTO);
}