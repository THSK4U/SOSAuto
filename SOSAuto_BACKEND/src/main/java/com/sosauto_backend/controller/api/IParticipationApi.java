package com.sosauto_backend.controller.api;


import com.sosauto_backend.model.Dto.ParticipationDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IParticipationApi {

    //creer
    @PostMapping(value = "/Participation/Creer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ParticipationDTO creerParticipation(@RequestBody ParticipationDTO Participation);

    //supprimer
    @DeleteMapping(value = "/Participation/Delete/{id}")
    void supprimerParticipation(@PathVariable("id") Long id);

    //Tous
    @GetMapping(value = "/Participation", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ParticipationDTO> getAllParticipation();

    //mettre A Jour
    @PutMapping(value = "/Participation/MettreAjour/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ParticipationDTO mettreAjourParticipation(@PathVariable("id") Long id,@RequestBody ParticipationDTO Participation);

    //By id
    @GetMapping(value = "/Participation/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ParticipationDTO getParticipationById(@PathVariable("id") Long id);
}
