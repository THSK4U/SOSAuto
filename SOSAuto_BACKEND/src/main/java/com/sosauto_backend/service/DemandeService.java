package com.sosauto_backend.service;

import com.sosauto_backend.model.Dto.DemandeDepannageDTO;
import com.sosauto_backend.model.Entity.DemandeDepannage;
import com.sosauto_backend.model.Mapper.DemandeDepannageMapper;
import com.sosauto_backend.model.Mapper.MécanicienMapper;
import com.sosauto_backend.respository.DemandeDepannageRepository;
import com.sosauto_backend.service.Interface.IDemandeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DemandeService implements IDemandeService {

    private DemandeDepannageMapper Mapper;

    private MécanicienMapper MécaMapper;


    private DemandeDepannageRepository Repository;

    @Override
    public DemandeDepannageDTO creer(DemandeDepannageDTO DemandeDePannage) {
        DemandeDepannage DemandeDePannages = Mapper.toEntity(DemandeDePannage);
        DemandeDepannage saved = Repository.save(DemandeDePannages);
        return Mapper.toDTO(saved);
    }

    @Override
    public DemandeDepannageDTO getById(Long id) {
        Optional<DemandeDepannage> DemandeDePannage = Repository.findById(id);
        return DemandeDePannage.map(Mapper::toDTO).orElse(null);
    }

    @Override
    public List<DemandeDepannageDTO> voirTous() {
        List<DemandeDepannage> DemandeDePannage = Repository.findAll();
        return DemandeDePannage.stream()
                .map(Mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DemandeDepannageDTO mettreAJour(Long id, DemandeDepannageDTO DTO) {
        Optional<DemandeDepannage> optional = Repository.findById(id);
        if (optional.isPresent()) {
            DemandeDepannage demandedepannage = optional.get();
            demandedepannage.setLongitude(DTO.getLongitude());
            demandedepannage.setLatitude(DTO.getLatitude());
            demandedepannage.setEtat(DTO.getEtat());
            demandedepannage.setMécanicien(MécaMapper.toEntity(DTO.getMécanicien()));

            DemandeDepannage updated = Repository.save(demandedepannage);
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

