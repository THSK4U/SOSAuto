package com.sosauto_backend.service.Interface;

import com.sosauto_backend.model.Dto.VehiculeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IVéhiculeService {
    //Creer
    VehiculeDTO creer(VehiculeDTO personne);

    //mettre A Jour
    VehiculeDTO mettreAJour(Long id, VehiculeDTO dto);

    //supprimer
    void supprimer(Long id);

    //consulter Tous
    List<VehiculeDTO> voirTous();

    //By ID
    VehiculeDTO getById(Long id);
}
