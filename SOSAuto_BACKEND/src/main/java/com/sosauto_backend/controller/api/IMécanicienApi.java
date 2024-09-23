package com.sosauto_backend.controller.api;


import com.sosauto_backend.model.Dto.MécanicienDTO;
import com.sosauto_backend.model.Entity.AuthResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sosauto_backend.utils.Constants.*;

public interface IMécanicienApi {

    //creer
    @PostMapping(value = APP_PERMIT_ALL + "/Mecanicien/Creer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AuthResponse creerMécanicien(@RequestBody MécanicienDTO mécanicien);

    //supprimer
    @DeleteMapping(value = APP_ADMIN_MECH + "/Mecanicien/Delete/{id}")
    void supprimerMécanicien(@PathVariable("id") Long id);

    //Tous
    @GetMapping(value = APP_ADMIN_AUTO + "/Mecanicien", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MécanicienDTO> getAllMécanicien();

    //mettre A Jour
    @PutMapping(value = APP_ADMIN_MECH + "/Mecanicien/MettreAjour/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MécanicienDTO mettreAjourMécanicien(@PathVariable("id") Long id,@RequestBody MécanicienDTO mécanicien);

    //By id
    @GetMapping(value = APP_PERMITALLAuth + "/Mecanicien/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    MécanicienDTO getMécanicienById(@PathVariable("id") Long id);

    //mettre A Jour Disponibilite
    @PutMapping(value = APP_MECH + "/Mecanicien/MettreAjour/{id}/Disponibilite", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MécanicienDTO mettreAjourDisponibilite(@PathVariable("id") Long id,@RequestBody MécanicienDTO mécanicien);

    //Tous Disponible
    @GetMapping(value = APP_ADMIN_AUTO + "/Mecanicien/Desponible", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MécanicienDTO> getAllMécanicienDesponible();

}
