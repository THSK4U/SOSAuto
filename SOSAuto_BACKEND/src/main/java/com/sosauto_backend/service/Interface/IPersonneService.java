package com.sosauto_backend.service.Interface;


import com.sosauto_backend.model.Dto.PersonneDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface IPersonneService {
    //Creer
    PersonneDTO creer(PersonneDTO personne);

    //mettre A Jour
    PersonneDTO mettreAJour(Long id, PersonneDTO DTO);

    //supprimer
    void supprimer(Long id);

    //consulter Tous
    List<PersonneDTO> voirTous();

    //By ID
    PersonneDTO getById(Long id);

    //Spring Security
    UserDetails loadUserByUsername(String numTelephone);
}