package com.sosauto_backend.controller.api;


import com.sosauto_backend.model.dto.MecanicienDTO;
import com.sosauto_backend.model.entity.AuthResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sosauto_backend.utils.Constants.*;

public interface IMecanicienApi {

    //creer
    @PostMapping(value = APP_PERMIT_ALL + "/Mecanicien/Creer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AuthResponse creerMecanicien(@RequestBody MecanicienDTO mecanicien);

    //supprimer
    @DeleteMapping(value = APP_ADMIN_MECH + "/Mecanicien/Delete/{id}")
    void supprimerMecanicien(@PathVariable("id") Long id);

    //Tous
    @GetMapping(value = APP_ADMIN_AUTO + "/Mecanicien", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MecanicienDTO> getAllMecanicien();

    //mettre A Jour
    @PutMapping(value = APP_ADMIN_MECH + "/Mecanicien/MettreAjour/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MecanicienDTO mettreAjourMecanicien(@PathVariable("id") Long id, @RequestBody MecanicienDTO mecanicien);

    //By id
    @GetMapping(value = APP_PERMITALL_AUTH + "/Mecanicien/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    MecanicienDTO getMecanicienById(@PathVariable("id") Long id);

    //mettre A Jour Disponibilite
    @PutMapping(value = APP_MECH + "/Mecanicien/MettreAjour/{id}/Disponibilite", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MecanicienDTO mettreAjourDisponibilite(@PathVariable("id") Long id, @RequestBody MecanicienDTO mecanicien);

    //Tous Disponible
    @GetMapping(value = APP_ADMIN_AUTO + "/Mecanicien/Desponible", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MecanicienDTO> getAllMecanicienDesponible();

    //ajouter Notation
    @PutMapping(value = APP_AUTO + "/Mecanicien/AddNotation/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MecanicienDTO addNotation(@PathVariable("id") Long mecanicienId, @RequestBody Double newRating);

}
