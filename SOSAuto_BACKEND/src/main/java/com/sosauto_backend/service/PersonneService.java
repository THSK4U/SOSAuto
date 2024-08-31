package com.sosauto_backend.service;


import com.sosauto_backend.model.Dto.PersonneDTO;
import com.sosauto_backend.model.Entity.Personne;
import com.sosauto_backend.model.Mapper.PersonneMapper;
import com.sosauto_backend.respository.PersonneRepository;
import com.sosauto_backend.service.Interface.IPersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PersonneService implements IPersonneService {
    @Autowired
    private PersonneMapper Mapper;
    @Autowired
    private PersonneRepository Repository;

    @Override
    public PersonneDTO creer(PersonneDTO personne) {
        Personne technicien = Mapper.toEntity(personne);
        Personne saved = Repository.save(technicien);
        return Mapper.toDTO(saved);
    }

    @Override
    public PersonneDTO getById(Long id) {
        Optional<Personne> personne = Repository.findById(id);
        return personne.map(Mapper::toDTO).orElse(null);
    }

    @Override
    public List<PersonneDTO> voirTous() {
        List<Personne> personne = Repository.findAll();
        return personne.stream()
                .map(Mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PersonneDTO mettreAJour(Long id, PersonneDTO DTO) {
        Optional<Personne> optional = Repository.findById(id);
        if (optional.isPresent()) {
            Personne personne = optional.get();
            personne.setNom(DTO.getNom());
            personne.setPrenom(DTO.getPrenom());
            personne.setEmail(DTO.getEmail());
            personne.setPassword(DTO.getPassword());

            Personne updated = Repository.save(personne);
            return Mapper.toDTO(updated);
        } else {
            return null;
        }
    }

    @Override
    public void supprimer(Long id) {
        Repository.deleteById(id);
    }

}