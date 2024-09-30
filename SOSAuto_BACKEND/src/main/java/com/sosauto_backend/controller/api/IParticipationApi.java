package com.sosauto_backend.controller.api;


import com.sosauto_backend.model.Dto.ParticipationDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sosauto_backend.utils.Constants.*;

public interface IParticipationApi {

    //creer
    @PostMapping(value = APP_MECH +"/Participation/Creer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ParticipationDTO> creerParticipation(@RequestBody ParticipationDTO participation);

    //supprimer
    @DeleteMapping(value = APP_ADMIN_MECH + "/Participation/Delete/{id}")
    void supprimerParticipation(@PathVariable("id") Long id);

    //supprimer
    @DeleteMapping(value = APP_ADMIN_MECH + "/Participation/DeleteByDemande/{Demandid}/Mecanicien/{Mecanicienid}")
    void supprimerParticipationByDemande(@PathVariable("Demandid") Long demandeId,
                                          @PathVariable("Mecanicienid") Long mecanicienId);

    //Tous
    @GetMapping(value = APP_ADMIN + "/Participation", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ParticipationDTO> getAllParticipation();

    //mettre A Jour
    @PutMapping(value = APP_ADMIN_MECH + "/Participation/MettreAjour/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ParticipationDTO mettreAjourParticipation(@PathVariable("id") Long id,@RequestBody ParticipationDTO participation);

    //By id
    @GetMapping(value = APP_PERMITALL_AUTH + "/Participation/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ParticipationDTO getParticipationById(@PathVariable("id") Long id);

    //By Mecanicienid
    @GetMapping(value = APP_ADMIN_MECH + "/Participation/Mecanicien/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ParticipationDTO> getALLParticipationByIdMecanicien(@PathVariable("id") Long id);

    //By Automobiliste
    @GetMapping(value = APP_ADMIN_MECH + "/Participation/Automobiliste/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ParticipationDTO> getALLParticipationByIdAutomobilist(@PathVariable("id") Long id);

    //By Demande
    @GetMapping(value = APP_ADMIN_AUTO + "/Participation/Demande/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ParticipationDTO> getALLParticipationByIDDemande(@PathVariable("id") Long id);

    @PostMapping(value = APP_AUTO +"/accept/{participationId}")
    ResponseEntity<ParticipationDTO> acceptParticipation(@PathVariable Long participationId);
    @PostMapping(value = APP_AUTO +"/reject/{participationId}")
    ResponseEntity<ParticipationDTO> rejectParticipation(@PathVariable Long participationId);

    //mettre A Jour
    @PutMapping(value = APP_ADMIN_MECH + "/Participation/{id}/Annuler")
    ParticipationDTO annulerParticipation(@PathVariable("id") Long id);
}
