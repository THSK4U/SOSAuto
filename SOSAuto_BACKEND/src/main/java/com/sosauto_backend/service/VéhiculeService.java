package com.sosauto_backend.service;

import com.sosauto_backend.model.Dto.VéhiculeDTO;
import com.sosauto_backend.service.Interface.IVéhiculeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VéhiculeService implements IVéhiculeService {

    @Override
    public VéhiculeDTO creer(VéhiculeDTO personne) {
        return null;
    }

    @Override
    public VéhiculeDTO mettreAJour(Long id, VéhiculeDTO DTO) {
        return null;
    }

    @Override
    public void supprimer(Long id) {

    }

    @Override
    public List<VéhiculeDTO> voirTous() {
        return List.of();
    }

    @Override
    public VéhiculeDTO getById(Long id) {
        return null;
    }
}
