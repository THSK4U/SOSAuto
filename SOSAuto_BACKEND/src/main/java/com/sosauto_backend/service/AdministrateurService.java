package com.sosauto_backend.service;

import com.sosauto_backend.model.Dto.AdministrateurDTO;
import com.sosauto_backend.service.Interface.IAdministrateurService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrateurService implements IAdministrateurService {

    @Override
    public AdministrateurDTO creer(AdministrateurDTO personne) {
        return null;
    }

    @Override
    public AdministrateurDTO mettreAJour(Long id, AdministrateurDTO DTO) {
        return null;
    }

    @Override
    public void supprimer(Long id) {

    }

    @Override
    public List<AdministrateurDTO> voirTous() {
        return List.of();
    }

    @Override
    public AdministrateurDTO getById(Long id) {
        return null;
    }
}
