package com.sosauto_backend.service;


import com.sosauto_backend.exception.CustomServiceException;
import com.sosauto_backend.model.dto.PersonneDTO;
import com.sosauto_backend.model.entity.Personne;
import com.sosauto_backend.model.mapper.PersonneMapper;
import com.sosauto_backend.respository.PersonneRepository;
import com.sosauto_backend.service.Interface.IPersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonneService implements IPersonneService, UserDetailsService {
    @Autowired
    private PersonneMapper mapper;
    @Autowired
    private PersonneRepository repository;

    @Override
    public PersonneDTO creer(PersonneDTO personne) {
        try {
            Personne technicien = mapper.toEntity(personne);
            Personne saved = repository.save(technicien);
            return mapper.toDTO(saved);
        } catch (Exception e) {
            throw new CustomServiceException("Erreur lors de la création de la personne : " + e.getMessage(), e);
        }
    }

    @Override
    public PersonneDTO getById(Long id) {
        try {
            Optional<Personne> personne = repository.findById(id);
            return personne.map(mapper::toDTO).orElse(null);
        } catch (Exception e) {
            throw new CustomServiceException("Erreur lors de la récupération de la personne par ID : " + e.getMessage(), e);
        }
    }


    @Override
    public List<PersonneDTO> voirTous() {
        try {
            List<Personne> personne = repository.findAll();
            return personne.stream()
                    .map(mapper::toDTO)
                    .toList();
        } catch (Exception e) {
            throw new CustomServiceException("Erreur lors de la récupération de toutes les personnes : " + e.getMessage(), e);

        }
    }

    @Override
    public PersonneDTO mettreAJour(Long id, PersonneDTO dto) {
        try {
            Optional<Personne> optional = repository.findById(id);
            if (optional.isPresent()) {
                Personne personne = optional.get();
                personne.setNom(dto.getNom());
                personne.setPrenom(dto.getPrenom());
                personne.setEmail(dto.getEmail());
                personne.setPassword(dto.getPassword()); // Consider hashing the password if it's being updated

                Personne updated = repository.save(personne);
                return mapper.toDTO(updated);
            } else {
                return null; // Or throw an exception for person not found
            }
        } catch (Exception e) {
            throw new CustomServiceException("Erreur lors de la mise à jour de la personne : " + e.getMessage(), e);

        }
    }

    @Override
    public void supprimer(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new CustomServiceException("Erreur lors de la suppression de la personne : " + e.getMessage(), e);

        }
    }

    @Override
    public UserDetails loadUserByUsername(String numtelephone) throws UsernameNotFoundException {
        try {
            return repository.findBynumTelephone(numtelephone)
                    .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));
        } catch (Exception e) {
            throw new CustomServiceException("Erreur lors du chargement de l'utilisateur par nom d'utilisateur : " + e.getMessage(), e);

        }
    }

}