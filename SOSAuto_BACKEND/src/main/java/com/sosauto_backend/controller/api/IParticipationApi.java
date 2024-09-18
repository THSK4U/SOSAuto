package com.sosauto_backend.controller.api;


import com.sosauto_backend.model.Dto.ParticipationDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    //supprimer
    @DeleteMapping(value = APP_ADMIN_MECH + "/Participation/DeleteByDemande/{Demandid}/Mecanicien/{Mecanicienid}")
    void supprimerParticipationByDemande(@PathVariable("Demandid") Long demandeId,
                                          @PathVariable("Mecanicienid") Long mecanicienId);

    //Tous
    @GetMapping(value = APP_ADMIN + "/Participation", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ParticipationDTO> getAllParticipation();

    //mettre A Jour
    @PutMapping(value = APP_ADMIN_MECH + "/Participation/MettreAjour/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ParticipationDTO mettreAjourParticipation(@PathVariable("id") Long id,@RequestBody ParticipationDTO Participation);

    //By id
    @GetMapping(value = APP_PERMITALLAuth + "/Participation/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ParticipationDTO getParticipationById(@PathVariable("id") Long id);

    //By Mecanicienid
    @GetMapping(value = APP_ADMIN_MECH + "/Participation/Mecanicien/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ParticipationDTO> getALLParticipationByIdMecanicien(@PathVariable("id") Long id);

    @PostMapping(value = APP_MECH +"/accept/{participationId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ParticipationDTO> acceptParticipation(@PathVariable Long participationId);
    @PostMapping(value = APP_MECH +"/reject/{participationId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ParticipationDTO> rejectParticipation(@PathVariable Long participationId);
}
