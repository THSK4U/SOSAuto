package com.sosauto_backend.controller.api;

import com.sosauto_backend.model.Dto.DemandeDepannageDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IDemandeApi {

    //creer
    @PostMapping(value = "/DemandeDepannage/Creer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    DemandeDepannageDTO creerDemande(@RequestBody DemandeDepannageDTO Demande);

    //supprimer
    @DeleteMapping(value = "/DemandeDepannage/Delete/{id}")
    void supprimerDemande(@PathVariable("id") Long id);

    //Tous
    @GetMapping(value = "/DemandeDepannage", produces = MediaType.APPLICATION_JSON_VALUE)
    List<DemandeDepannageDTO> getAllDemande();

    //mettre A Jour
    @PutMapping(value = "/DemandeDepannage/MettreAjour/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    DemandeDepannageDTO mettreAjourDemande(@PathVariable("id") Long id,@RequestBody DemandeDepannageDTO Demande);

    //By id
    @GetMapping(value = "/DemandeDepannage/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    DemandeDepannageDTO getDemandeById(@PathVariable("id") Long id);
}
