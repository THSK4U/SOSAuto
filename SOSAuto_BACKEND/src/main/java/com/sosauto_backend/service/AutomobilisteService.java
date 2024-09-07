package com.sosauto_backend.service;

import com.sosauto_backend.model.Dto.AutomobilisteDTO;
import com.sosauto_backend.model.Entity.Automobiliste;
import com.sosauto_backend.model.Mapper.AutomobilisteMapper;
import com.sosauto_backend.respository.AutomobilisteRepository;
import com.sosauto_backend.service.Interface.IAutomobilisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutomobilisteService implements IAutomobilisteService {

    @Autowired
    private AutomobilisteMapper Mapper;

    @Autowired
    private AutomobilisteRepository Repository;

    @Override
    public AutomobilisteDTO creer(AutomobilisteDTO Automobiliste) {
        Automobiliste Automobilistes = Mapper.toEntity(Automobiliste);
        Automobiliste saved = Repository.save(Automobilistes);
        return Mapper.toDTO(saved);
    }

    @Override
    public AutomobilisteDTO getById(Long id) {
        Optional<Automobiliste> automobiliste = Repository.findById(id);
        return automobiliste.map(Mapper::toDTO).orElse(null);
    }

    @Override
    public List<AutomobilisteDTO> voirTous() {
        List<Automobiliste> automobiliste = Repository.findAll();
        return automobiliste.stream()
                .map(Mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AutomobilisteDTO mettreAJour(Long id, AutomobilisteDTO DTO) {
        Optional<Automobiliste> optional = Repository.findById(id);
        if (optional.isPresent()) {
            Automobiliste automobiliste = optional.get();
            automobiliste.setEmail(DTO.getEmail());
            automobiliste.setNom(DTO.getNom());
            automobiliste.setPrenom(DTO.getPrenom());
            automobiliste.setPassword(DTO.getPassword());


            Automobiliste updated = Repository.save(automobiliste);
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
