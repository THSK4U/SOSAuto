package com.sosauto_backend.service;

import com.sosauto_backend.model.Dto.PanneDTO;
import com.sosauto_backend.model.Entity.Panne;
import com.sosauto_backend.model.Mapper.PanneMapper;
import com.sosauto_backend.respository.PanneRepository;
import com.sosauto_backend.service.Interface.IPanneService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PanneService implements IPanneService {

    private PanneMapper Mapper;

    private PanneRepository Repository;

    @Override
    public PanneDTO creer(PanneDTO panne) {
        Panne pannes = Mapper.toEntity(panne);
        Panne saved = Repository.save(pannes);
        return Mapper.toDTO(saved);
    }

    @Override
    public PanneDTO getById(Long id) {
        Optional<Panne> panne = Repository.findById(id);
        return panne.map(Mapper::toDTO).orElse(null);
    }

    @Override
    public List<PanneDTO> voirTous() {
        List<Panne> panne = Repository.findAll();
        return panne.stream()
                .map(Mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PanneDTO mettreAJour(Long id, PanneDTO DTO) {
        Optional<Panne> optional = Repository.findById(id);
        if (optional.isPresent()) {
            Panne panne = optional.get();
            panne.setNom(DTO.getNom());
            panne.setDescription(DTO.getDescription());

            Panne updated = Repository.save(panne);
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
