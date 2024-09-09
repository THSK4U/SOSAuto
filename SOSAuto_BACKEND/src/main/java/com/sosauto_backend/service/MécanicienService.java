package com.sosauto_backend.service;


import com.sosauto_backend.model.Dto.MécanicienDTO;
import com.sosauto_backend.model.Entity.AuthResponse;
import com.sosauto_backend.model.Entity.Mécanicien;
import com.sosauto_backend.model.Enum.Disponibilite;
import com.sosauto_backend.model.Mapper.MécanicienMapper;
import com.sosauto_backend.respository.MécanicienRepository;
import com.sosauto_backend.service.Interface.IAuthenticationService;
import com.sosauto_backend.service.Interface.IMécanicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MécanicienService implements IMécanicienService {

    @Autowired
    private MécanicienMapper Mapper;

    @Autowired
    private MécanicienRepository Repository;

    @Autowired
    private IAuthenticationService authenticationService;


    @Override
    public AuthResponse creer(MécanicienDTO Mécanicien) {
        Mécanicien.setDisponible(Disponibilite.INDISPONIBLE);
        return authenticationService.registerMecanicien(Mécanicien);
    }

    @Override
    public MécanicienDTO getById(Long id) {
        Optional<Mécanicien> mécanicien = Repository.findById(id);
        return mécanicien.map(Mapper::toDTO).orElse(null);
    }

    @Override
    public MécanicienDTO mettreAJourdisponibilite(Long id, MécanicienDTO DTO) {
        Optional<Mécanicien> optional = Repository.findById(id);
        if (optional.isPresent()) {
            Mécanicien mécanicien = optional.get();
            mécanicien.setDisponible(DTO.getDisponible());
            return Mapper.toDTO(Repository.save(mécanicien));
        } else {
            return null;
        }
    }

    @Override
    public List<MécanicienDTO> getDisponibilite() {
        List<Mécanicien> mécanicien = Repository.getAllByDisponible(Disponibilite.DISPONIBLE);
        return mécanicien.stream()
                .map(Mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MécanicienDTO> voirTous() {
        List<Mécanicien> mécanicien = Repository.findAll();
        return mécanicien.stream()
                .map(Mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MécanicienDTO mettreAJour(Long id, MécanicienDTO DTO) {
        Optional<Mécanicien> optional = Repository.findById(id);
        if (optional.isPresent()) {
            Mécanicien mécanicien = optional.get();
            mécanicien.setEmail(DTO.getEmail());
            mécanicien.setNom(DTO.getNom());
            mécanicien.setPrenom(DTO.getPrenom());
            mécanicien.setPassword(DTO.getPassword());

            Mécanicien updated = Repository.save(mécanicien);
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
