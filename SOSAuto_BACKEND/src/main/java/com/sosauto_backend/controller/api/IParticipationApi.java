package com.sosauto_backend.controller.api;


import com.sosauto_backend.model.Dto.ParticipationDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sosauto_backend.controller.utils.Constants.*;

public interface IParticipationApi {

    //creer
    @PostMapping(value = APP_MECH +"/Participation/Creer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ParticipationDTO creerParticipation(@RequestBody ParticipationDTO Participation);

    //supprimer
    @DeleteMapping(value = APP_ADMIN_MECH + "/Participation/Delete/{id}")
    void supprimerParticipation(@PathVariable("id") Long id);

    //Tous
    @GetMapping(value = APP_ADMIN + "/Participation", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ParticipationDTO> getAllParticipation();

    //mettre A Jour
    @PutMapping(value = APP_ADMIN_MECH + "/Participation/MettreAjour/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ParticipationDTO mettreAjourParticipation(@PathVariable("id") Long id,@RequestBody ParticipationDTO Participation);

    //By id
    @GetMapping(value = APP_PERMITALLAuth + "/Participation/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ParticipationDTO getParticipationById(@PathVariable("id") Long id);
}
