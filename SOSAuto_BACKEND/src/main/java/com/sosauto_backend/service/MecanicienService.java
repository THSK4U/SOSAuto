package com.sosauto_backend.service;


import com.sosauto_backend.model.dto.MecanicienDTO;
import com.sosauto_backend.model.entity.AuthResponse;
import com.sosauto_backend.model.entity.Mecanicien;
import com.sosauto_backend.model.enums.Disponibilite;
import com.sosauto_backend.model.mapper.MecanicienMapper;
import com.sosauto_backend.respository.MecanicienRepository;
import com.sosauto_backend.service.Interface.IAuthenticationService;
import com.sosauto_backend.service.Interface.IMecanicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MecanicienService implements IMecanicienService {

    @Autowired
    private MecanicienMapper mapper;

    @Autowired
    private MecanicienRepository repository;

    @Autowired
    private IAuthenticationService authenticationservice;



    @Override
    public AuthResponse creer(MecanicienDTO mecanicien) {
        try {
            mecanicien.setDisponible(Disponibilite.INDISPONIBLE);
            return authenticationservice.registerMecanicien(mecanicien);
        } catch (Exception e) {
            System.err.println("Erreur lors de la création du mécanicien : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public MecanicienDTO getById(Long id) {
        try {
            Optional<Mecanicien> mecanicien = repository.findById(id);
            return mecanicien.map(mapper::toDTO).orElse(null);
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération du mécanicien par ID : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public MecanicienDTO mettreAJourdisponibilite(Long id, MecanicienDTO dto) {
        try {
            Optional<Mecanicien> optional = repository.findById(id);
            if (optional.isPresent()) {
                Mecanicien mecanicien = optional.get();
                mecanicien.setDisponible(dto.getDisponible());
                return mapper.toDTO(repository.save(mecanicien));
            } else {
                return null; // Or throw an exception for mechanic not found
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour de la disponibilité du mécanicien : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<MecanicienDTO> getDisponibilite() {
        try {
            List<Mecanicien> mecanicien = repository.getAllByDisponible(Disponibilite.DISPONIBLE);
            return mecanicien.stream()
                    .map(mapper::toDTO)
                    .toList();
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération des mécaniciens disponibles : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public MecanicienDTO addNotation(Long mecanicienId, Double newRating) {
        try {
            Optional<Mecanicien> optional = repository.findById(mecanicienId);
            if (optional.isPresent()) {
                Mecanicien mecanicien = optional.get();
                if (mecanicien.getNotation() == null) {
                    mecanicien.setNotation(newRating);
                } else {
                    mecanicien.setNotation((mecanicien.getNotation() + newRating) / 2);
                }
                return mapper.toDTO(repository.save(mecanicien));
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour de la notation du mécanicien : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<MecanicienDTO> voirTous() {
        try {
            List<Mecanicien> mecanicien = repository.findAll();
            return mecanicien.stream()
                    .map(mapper::toDTO)
                    .toList();
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération de tous les mécaniciens : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public MecanicienDTO mettreAJour(Long id, MecanicienDTO dto) {
        try {
            Optional<Mecanicien> optional = repository.findById(id);
            if (optional.isPresent()) {
                Mecanicien mecanicien = optional.get();
                mecanicien.setEmail(dto.getEmail());
                mecanicien.setNom(dto.getNom());
                mecanicien.setPrenom(dto.getPrenom());
                mecanicien.setPassword(dto.getPassword()); // Consider hashing the password

                Mecanicien updated = repository.save(mecanicien);
                return mapper.toDTO(updated);
            } else {
                return null; // Or throw an exception for mechanic not found
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour du mécanicien : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void supprimer(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression du mécanicien : " + e.getMessage());
            throw e;
        }
    }
}