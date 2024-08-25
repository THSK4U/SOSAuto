package com.sosauto_backend.service.Interface;

import com.sosauto_backend.model.Dto.VéhiculeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IVéhiculeService {
    //Creer
    VéhiculeDTO creer(VéhiculeDTO personne);

    //mettre A Jour
    VéhiculeDTO mettreAJour(Long id, VéhiculeDTO DTO);

    //supprimer
    void supprimer(Long id);

    //consulter Tous
    List<VéhiculeDTO> voirTous();

    //By ID
    VéhiculeDTO getById(Long id);
}
