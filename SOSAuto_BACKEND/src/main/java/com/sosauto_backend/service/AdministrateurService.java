package com.sosauto_backend.service;

import com.sosauto_backend.model.Dto.AdministrateurDTO;
import com.sosauto_backend.model.Entity.Administrateur;
import com.sosauto_backend.model.Mapper.AdministrateurMapper;
import com.sosauto_backend.respository.AdministrateurRepository;
import com.sosauto_backend.service.Interface.IAdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdministrateurService implements IAdministrateurService {

    @Autowired
    private AdministrateurMapper Mapper;

    @Autowired
    private AdministrateurRepository Repository;

    @Override
    public AdministrateurDTO creer(AdministrateurDTO Administrateur) {
        Administrateur Administrateurs = Mapper.toEntity(Administrateur);
        Administrateur saved = Repository.save(Administrateurs);
        return Mapper.toDTO(saved);
    }

    @Override
    public AdministrateurDTO getById(Long id) {
        Optional<Administrateur> administrateur = Repository.findById(id);
        return administrateur.map(Mapper::toDTO).orElse(null);
    }

    @Override
    public List<AdministrateurDTO> voirTous() {
        List<Administrateur> administrateur = Repository.findAll();
        return administrateur.stream()
                .map(Mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AdministrateurDTO mettreAJour(Long id, AdministrateurDTO DTO) {
        Optional<Administrateur> optional = Repository.findById(id);
        if (optional.isPresent()) {
            Administrateur administrateur = optional.get();
            administrateur.setEmail(DTO.getEmail());
            administrateur.setNom(DTO.getNom());
            administrateur.setPrenom(DTO.getPrenom());
            administrateur.setPassword(DTO.getPassword());


            Administrateur updated = Repository.save(administrateur);
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
