package com.sosauto_backend.service;

import com.sosauto_backend.model.Dto.AutomobilisteDTO;
import com.sosauto_backend.service.Interface.IAutomobilisteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomobilisteService implements IAutomobilisteService {

    @Override
    public AutomobilisteDTO creer(AutomobilisteDTO personne) {
        return null;
    }

    @Override
    public AutomobilisteDTO mettreAJour(Long id, AutomobilisteDTO DTO) {
        return null;
    }

    @Override
    public void supprimer(Long id) {

    }

    @Override
    public List<AutomobilisteDTO> voirTous() {
        return List.of();
    }

    @Override
    public AutomobilisteDTO getById(Long id) {
        return null;
    }
}
