package com.sosauto_backend.service;

import com.sosauto_backend.model.Dto.DemandeDepannageDTO;
import com.sosauto_backend.service.Interface.IDemandeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeService implements IDemandeService {
    @Override
    public DemandeDepannageDTO creer(DemandeDepannageDTO personne) {
        return null;
    }

    @Override
    public DemandeDepannageDTO mettreAJour(Long id, DemandeDepannageDTO DTO) {
        return null;
    }

    @Override
    public void supprimer(Long id) {

    }

    @Override
    public List<DemandeDepannageDTO> voirTous() {
        return List.of();
    }

    @Override
    public DemandeDepannageDTO getById(Long id) {
        return null;
    }
}

