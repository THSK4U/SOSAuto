package com.sosauto_backend.service;

import com.sosauto_backend.model.Dto.PanneDTO;
import com.sosauto_backend.service.Interface.IPanneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanneService implements IPanneService {

    @Override
    public PanneDTO creer(PanneDTO personne) {
        return null;
    }

    @Override
    public PanneDTO mettreAJour(Long id, PanneDTO DTO) {
        return null;
    }

    @Override
    public void supprimer(Long id) {

    }

    @Override
    public List<PanneDTO> voirTous() {
        return List.of();
    }

    @Override
    public PanneDTO getById(Long id) {
        return null;
    }
}
