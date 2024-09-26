package com.sosauto_backend.service;

import com.sosauto_backend.model.Dto.ParticipationDTO;
import com.sosauto_backend.model.Entity.Participation;
import com.sosauto_backend.model.Enum.StatutParticipation;
import com.sosauto_backend.model.Mapper.ParticipationMapper;
import com.sosauto_backend.respository.ParticipationRepository;
import com.sosauto_backend.service.Interface.IParticipationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParticipationService implements IParticipationService {

    @Autowired
    private ParticipationMapper mapper;

    @Autowired
    private ParticipationRepository repository;

    @Override
    public ParticipationDTO creer(ParticipationDTO participationDTO) {
        Participation participation = mapper.toEntity(participationDTO);
        participation.setStatus(StatutParticipation.EN_ATTENTE);
        Participation saved = repository.save(participation);
        return mapper.toDTO(saved);
    }

    @Override
    public ParticipationDTO mettreAJour(Long id, ParticipationDTO participationDTO) {
        Optional<Participation> optionalParticipation = repository.findById(id);
        if (optionalParticipation.isPresent()) {
            Participation participation = optionalParticipation.get();
            participation.setDemande(participationDTO.getDemande());
            participation.setStatus(participationDTO.getStatus());
            Participation updated = repository.save(participation);
            return mapper.toDTO(updated);
        } else {
            throw new EntityNotFoundException("Participation not found with id: " + id);
        }
    }

    @Override
    public void supprimer(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Participation not found with id: " + id);
        }
    }

    @Override
    public void supprimerByDemande(Long demandeId, Long mecanicienId) {
        repository.deleteByDemande_DemandeidAndMecanicien_Personneid(demandeId, mecanicienId);
    }

    @Override
    public List<ParticipationDTO> voirTous() {
        List<Participation> participations = repository.findAll();
        return participations.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ParticipationDTO getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Participation not found with id: " + id));
    }

    @Override
    public List<ParticipationDTO> getByMecanicienId(Long id) {
        List<Participation> participations = repository.getAllByMecanicien_Personneid(id);
        return participations.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ParticipationDTO> getByDemande_AutomobilistId(Long id) {
        List<Participation> participations = repository.findParticipationsByautomobiliste_id(id);
        return participations.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ParticipationDTO acceptParticipation(Long participationId) {
        Participation participation = repository.findById(participationId)
                .orElseThrow(() -> new EntityNotFoundException("Participation not found with id: " + participationId));
        participation.setStatus(StatutParticipation.ACCEPTE);
        Participation updated = repository.save(participation);
        return mapper.toDTO(updated);
    }

    @Override
    public ParticipationDTO rejectParticipation(Long participationId) {
        Participation participation = repository.findById(participationId)
                .orElseThrow(() -> new EntityNotFoundException("Participation not found with id: " + participationId));
        participation.setStatus(StatutParticipation.REFUSE);
        Participation updated = repository.save(participation);
        return mapper.toDTO(updated);
    }

    @Override
    public ParticipationDTO annulerParticipation(Long participationId) {
        Optional<Participation> optionalParticipation = repository.findById(participationId);
        if (optionalParticipation.isPresent()) {
            Participation participation = optionalParticipation.get();
            participation.setStatus(StatutParticipation.ANNULER);
            Participation updated = repository.save(participation);
            return mapper.toDTO(updated);
        } else {
            throw new EntityNotFoundException("Participation not found with id: " + participationId);
        }
    }

}
