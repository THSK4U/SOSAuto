package com.sosauto_backend.service;



import com.sosauto_backend.model.Dto.VéhiculeDTO;
import com.sosauto_backend.model.Entity.Véhicule;
import com.sosauto_backend.model.Mapper.véhiculeMapper;
import com.sosauto_backend.respository.VéhiculeRepository;
import com.sosauto_backend.service.Interface.IVéhiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VéhiculeService implements IVéhiculeService {

    @Autowired
    private véhiculeMapper Mapper;

    @Autowired
    private VéhiculeRepository Repository;

    @Override
    public VéhiculeDTO creer(VéhiculeDTO Véhicule) {
        Véhicule véhicule = Mapper.toEntity(Véhicule);
        Véhicule saved = Repository.save(véhicule);
        return Mapper.toDTO(saved);
    }

    @Override
    public VéhiculeDTO getById(Long id) {
        Optional<Véhicule> Véhicule = Repository.findById(id);
        return Véhicule.map(Mapper::toDTO).orElse(null);
    }

    @Override
    public List<VéhiculeDTO> voirTous() {
        List<Véhicule> Véhicule = Repository.findAll();
        return Véhicule.stream()
                .map(Mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VéhiculeDTO mettreAJour(Long id, VéhiculeDTO DTO) {
        Optional<Véhicule> optional = Repository.findById(id);
        if (optional.isPresent()) {
            Véhicule Véhicule = optional.get();
            Véhicule.setAnnée(DTO.getAnnée());
            Véhicule.setModele(DTO.getModele());
            Véhicule.setCouleur(DTO.getCouleur());
            Véhicule.setMarque(DTO.getMarque());
            Véhicule.setMatricule(DTO.getMatricule());

            Véhicule updated = Repository.save(Véhicule);
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
