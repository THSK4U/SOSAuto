package com.sosauto_backend.service;

import com.sosauto_backend.model.Dto.MécanicienDTO;
import com.sosauto_backend.service.Interface.IMécanicienService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MécanicienService implements IMécanicienService {

    @Override
    public MécanicienDTO creer(MécanicienDTO personne) {
        return null;
    }

    @Override
    public MécanicienDTO mettreAJour(Long id, MécanicienDTO DTO) {
        return null;
    }

    @Override
    public void supprimer(Long id) {

    }

    @Override
    public List<MécanicienDTO> voirTous() {
        return List.of();
    }

    @Override
    public MécanicienDTO getById(Long id) {
        return null;
    }
}
