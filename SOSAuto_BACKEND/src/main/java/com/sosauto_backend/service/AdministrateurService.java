package com.sosauto_backend.service;

import com.sosauto_backend.model.Dto.AdministrateurDTO;
import com.sosauto_backend.model.Entity.Administrateur;
import com.sosauto_backend.model.Entity.AuthResponse;
import com.sosauto_backend.model.Mapper.AdministrateurMapper;
import com.sosauto_backend.respository.AdministrateurRepository;
import com.sosauto_backend.service.Interface.IAdministrateurService;
import com.sosauto_backend.service.Interface.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdministrateurService implements IAdministrateurService {

    @Autowired
    private AdministrateurMapper mapper;

    @Autowired
    private AdministrateurRepository repository;

    @Autowired
    private IAuthenticationService authenticationservice;

    @Override
    public AuthResponse creer(AdministrateurDTO administrateur) {
        try {
            return authenticationservice.registerAdmin(administrateur);
        } catch (Exception e) {
            System.err.println("Error creating administrator: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public AdministrateurDTO getById(Long id) {
        try {
            Optional<Administrateur> administrateur = repository.findById(id);
            return administrateur.map(mapper::toDTO).orElse(null);
        } catch (Exception e) {
            System.err.println("Error getting administrator by ID: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<AdministrateurDTO> voirTous() {
        try {
            List<Administrateur> administrateur = repository.findAll();
            return administrateur.stream()
                    .map(mapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println("Error getting all administrators: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public AdministrateurDTO mettreAJour(Long id, AdministrateurDTO dto) {
        try {
            Optional<Administrateur> optional = repository.findById(id);
            if (optional.isPresent()) {
                Administrateur administrateur = optional.get();
                administrateur.setEmail(dto.getEmail());
                administrateur.setNom(dto.getNom());
                administrateur.setPrenom(dto.getPrenom());
                administrateur.setPassword(dto.getPassword());

                Administrateur updated = repository.save(administrateur);
                return mapper.toDTO(updated);
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error updating administrator: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void supprimer(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            System.err.println("Error deleting administrator: " + e.getMessage());
            throw e;
        }
    }
}