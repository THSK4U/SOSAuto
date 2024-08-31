package com.sosauto_backend.service;

import com.sosauto_backend.model.Dto.ParticipationDTO;
import com.sosauto_backend.model.Entity.Participation;
import com.sosauto_backend.model.Enum.StatutParticipation;
import com.sosauto_backend.model.Mapper.ParticipationMapper;
import com.sosauto_backend.respository.ParticipationRepository;
import com.sosauto_backend.service.Interface.IParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParticipationService implements IParticipationService {
    @Autowired
    private ParticipationMapper Mapper;
    @Autowired
    private ParticipationRepository Repository;

    @Override
    public ParticipationDTO creer(ParticipationDTO participation) {
        Participation p = Mapper.toEntity(participation);
        p.setStatus(StatutParticipation.EN_ATTENTE);
        Participation saved = Repository.save(p);
        return Mapper.toDTO(saved);
    }

    @Override
    public ParticipationDTO mettreAJour(Long id, ParticipationDTO DTO) {
        Optional<Participation> optional = Repository.findById(id);
        if (optional.isPresent()) {
            Participation P = optional.get();
            P.setDemande(DTO.getDemande());
            P.setStatus(DTO.getStatus());
            P.setMecanicien(DTO.getMecanicien());

            Participation updated = Repository.save(P);
            return Mapper.toDTO(updated);
        } else {
            return null;
        }
    }

    @Override
    public void supprimer(Long id) {
        Repository.deleteById(id);

    }

    @Override
    public List<ParticipationDTO> voirTous() {
        List<Participation> p = Repository.findAll();
        return p.stream()
                .map(Mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ParticipationDTO getById(Long id) {
        Optional<Participation> optional = Repository.findById(id);
        return optional.map(Mapper::toDTO).orElse(null);
    }
}
