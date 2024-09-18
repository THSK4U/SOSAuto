package com.sosauto_backend.service;

import com.sosauto_backend.model.Dto.DemandeDepannageDTO;
import com.sosauto_backend.model.Entity.DemandeDepannage;
import com.sosauto_backend.model.Enum.EtatPanne;
import com.sosauto_backend.model.Mapper.DemandeDepannageMapper;
import com.sosauto_backend.model.Mapper.MécanicienMapper;
import com.sosauto_backend.respository.DemandeDepannageRepository;
import com.sosauto_backend.service.Interface.IDemandeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DemandeService implements IDemandeService {

    @Autowired
    private DemandeDepannageMapper Mapper;

    @Autowired
    private DemandeDepannageRepository Repository;

    @Override
    public DemandeDepannageDTO creer(DemandeDepannageDTO DemandeDePannage) {
        DemandeDepannage DemandeDePannages = Mapper.toEntity(DemandeDePannage);
        DemandeDePannages.setEtat(EtatPanne.A_FAIRE);
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
            demandedepannage.setMécanicien(DTO.getMécanicien());
            demandedepannage.setPanne(DTO.getPanne());
            demandedepannage.setDescription(DTO.getDescription());

            DemandeDepannage updated = Repository.save(demandedepannage);
            return Mapper.toDTO(updated);
        } else {
            throw new EntityNotFoundException("DemandeDepannage with ID " + id + " not found");
        }
    }

    @Override
    public void supprimer(Long id) {
        Repository.deleteById(id);
    }

}

