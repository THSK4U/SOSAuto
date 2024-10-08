package com.sosauto_backend.service;

import com.sosauto_backend.exception.CustomServiceException;
import com.sosauto_backend.model.dto.AdministrateurDTO;
import com.sosauto_backend.model.entity.Administrateur;
import com.sosauto_backend.model.entity.AuthResponse;
import com.sosauto_backend.model.mapper.AdministrateurMapper;
import com.sosauto_backend.respository.AdministrateurRepository;
import com.sosauto_backend.service.Interface.IAdministrateurService;
import com.sosauto_backend.service.Interface.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            throw new CustomServiceException("Error creating administrator", e);

        }
    }

    @Override
    public AdministrateurDTO getById(Long id) {
        try {
            Optional<Administrateur> administrateur = repository.findById(id);
            return administrateur.map(mapper::toDTO).orElse(null);
        } catch (Exception e) {
            throw new CustomServiceException("Error getting administrator by ID", e);

        }
    }

    @Override
    public List<AdministrateurDTO> voirTous() {
        try {
            List<Administrateur> administrateur = repository.findAll();
            return administrateur.stream()
                    .map(mapper::toDTO)
                    .toList();
        } catch (Exception e) {
            throw new CustomServiceException("Error getting all administrators", e);

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
            throw new CustomServiceException("Error updating administrator", e);

        }
    }

    @Override
    public void supprimer(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new CustomServiceException("Error deleting administrator", e);

        }
    }
}