package com.sosauto_backend.service;


import com.sosauto_backend.model.Dto.MecanicienDTO;
import com.sosauto_backend.model.Entity.AuthResponse;
import com.sosauto_backend.model.Entity.Mecanicien;
import com.sosauto_backend.model.Enum.Disponibilite;
import com.sosauto_backend.model.Mapper.MecanicienMapper;
import com.sosauto_backend.respository.MecanicienRepository;
import com.sosauto_backend.service.Interface.IAuthenticationService;
import com.sosauto_backend.service.Interface.IMecanicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MecanicienService implements IMecanicienService {

    @Autowired
    private MecanicienMapper Mapper;

    @Autowired
    private MecanicienRepository Repository;

    @Autowired
    private IAuthenticationService authenticationService;


    @Override
    public AuthResponse creer(MecanicienDTO Mécanicien) {
        Mécanicien.setDisponible(Disponibilite.INDISPONIBLE);
        return authenticationService.registerMecanicien(Mécanicien);
    }

    @Override
    public MecanicienDTO getById(Long id) {
        Optional<Mecanicien> mécanicien = Repository.findById(id);
        return mécanicien.map(Mapper::toDTO).orElse(null);
    }

    @Override
    public MecanicienDTO mettreAJourdisponibilite(Long id, MecanicienDTO DTO) {
        Optional<Mecanicien> optional = Repository.findById(id);
        if (optional.isPresent()) {
            Mecanicien mecanicien = optional.get();
            mecanicien.setDisponible(DTO.getDisponible());
            return Mapper.toDTO(Repository.save(mecanicien));
        } else {
            return null;
        }
    }

    @Override
    public List<MecanicienDTO> getDisponibilite() {
        List<Mecanicien> mecanicien = Repository.getAllByDisponible(Disponibilite.DISPONIBLE);
        return mecanicien.stream()
                .map(Mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MecanicienDTO> voirTous() {
        List<Mecanicien> mecanicien = Repository.findAll();
        return mecanicien.stream()
                .map(Mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MecanicienDTO mettreAJour(Long id, MecanicienDTO DTO) {
        Optional<Mecanicien> optional = Repository.findById(id);
        if (optional.isPresent()) {
            Mecanicien mecanicien = optional.get();
            mecanicien.setEmail(DTO.getEmail());
            mecanicien.setNom(DTO.getNom());
            mecanicien.setPrenom(DTO.getPrenom());
            mecanicien.setPassword(DTO.getPassword());

            Mecanicien updated = Repository.save(mecanicien);
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
