package com.sosauto_backend.service;

import com.sosauto_backend.model.dto.AutomobilisteDTO;
import com.sosauto_backend.model.entity.AuthResponse;
import com.sosauto_backend.model.entity.Automobiliste;
import com.sosauto_backend.model.mapper.AutomobilisteMapper;
import com.sosauto_backend.respository.AutomobilisteRepository;
import com.sosauto_backend.service.Interface.IAuthenticationService;
import com.sosauto_backend.service.Interface.IAutomobilisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutomobilisteService implements IAutomobilisteService {

    @Autowired
    private AutomobilisteMapper mapper;

    @Autowired
    private AutomobilisteRepository repository;

    @Autowired
    private IAuthenticationService authenticationservice;

    @Override
    public AuthResponse creer(AutomobilisteDTO automobiliste) {
        try {
            return authenticationservice.registerAutomobiliste(automobiliste);
        } catch (Exception e) {
            System.err.println("Error creating automobilist: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public AutomobilisteDTO getById(Long id) {
        try {
            Optional<Automobiliste> automobiliste = repository.findById(id);
            return automobiliste.map(mapper::toDTO).orElse(null);
        } catch (Exception e) {
            System.err.println("Error getting automobilist by ID: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<AutomobilisteDTO> voirTous() {
        try {
            List<Automobiliste> automobiliste = repository.findAll();
            return automobiliste.stream()
                    .map(mapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println("Error getting all automobilists: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public AutomobilisteDTO mettreAJour(Long id, AutomobilisteDTO dto) {
        try {
            Optional<Automobiliste> optional = repository.findById(id);
            if (optional.isPresent()) {
                Automobiliste automobiliste = optional.get();
                automobiliste.setEmail(dto.getEmail());
                automobiliste.setNom(dto.getNom());
                automobiliste.setPrenom(dto.getPrenom());
                automobiliste.setPassword(dto.getPassword());

                Automobiliste updated = repository.save(automobiliste);
                return mapper.toDTO(updated);
            } else {
                return null; // Or throw an exception indicating the automobilist was not found
            }
        } catch (Exception e) {
            System.err.println("Error updating automobilist: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void supprimer(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            System.err.println("Error deleting automobilist: " + e.getMessage());
            throw e;
        }
    }
}