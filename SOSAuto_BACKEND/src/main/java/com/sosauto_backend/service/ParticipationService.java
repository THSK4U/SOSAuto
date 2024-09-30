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
    public ParticipationDTO creer(ParticipationDTO participationdto) {
        try {
            Participation participation = mapper.toEntity(participationdto);
            participation.setStatus(StatutParticipation.EN_ATTENTE);
            Participation saved = repository.save(participation);
            return mapper.toDTO(saved);
        } catch (Exception e) {
            System.err.println("Erreur lors de la création de la participation : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public ParticipationDTO mettreAJour(Long id, ParticipationDTO participationdto) {
        try {
            Optional<Participation> optionalParticipation = repository.findById(id);
            if (optionalParticipation.isPresent()) {
                Participation participation = optionalParticipation.get();
                participation.setDemande(participationdto.getDemande());
                participation.setStatus(participationdto.getStatus());
                Participation updated = repository.save(participation);
                return mapper.toDTO(updated);
            } else {
                throw new EntityNotFoundException("Participation non trouvée avec l'ID : " + id);
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour de la participation : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void supprimer(Long id) {
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
            } else {
                throw new EntityNotFoundException("Participation non trouvée avec l'ID : " + id);
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression de la participation : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void supprimerByDemande(Long demandeid, Long mecanicienid) {
        try {
            repository.deleteByDemande_DemandeidAndMecanicien_Personneid(demandeid, mecanicienid);
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression de la participation par demande : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<ParticipationDTO> voirTous() {
        try {
            List<Participation> participations = repository.findAll();
            return participations.stream()
                    .map(mapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération de toutes les participations : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public ParticipationDTO getById(Long id) {
        try {
            return repository.findById(id)
                    .map(mapper::toDTO)
                    .orElseThrow(() -> new EntityNotFoundException("Participation non trouvée avec l'ID : " + id));
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération de la participation par ID : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<ParticipationDTO> getByMecanicienId(Long id) {
        try {
            List<Participation> participations = repository.getAllByMecanicien_Personneid(id);
            return participations.stream()
                    .map(mapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération des participations par ID du mécanicien : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<ParticipationDTO> getByDemande_AutomobilistId(Long id) {
        try {
            List<Participation> participations = repository.findParticipationsByautomobiliste_id(id);
            return participations.stream()
                    .map(mapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération des participations par ID de l'automobiliste : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<ParticipationDTO> getALLByDemandeID(Long id) {
        try {
            List<Participation> participations = repository.findAllByDemande_Demandeid(id);
            return participations.stream()
                    .map(mapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération de toutes les participations par ID de la demande : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public ParticipationDTO acceptParticipation(Long participationid) {
        try {
            Participation participation = repository.findById(participationid)
                    .orElseThrow(() -> new EntityNotFoundException("Participation non trouvée avec l'ID : " + participationid));
            participation.setStatus(StatutParticipation.ACCEPTE);
            Participation updated = repository.save(participation);
            return mapper.toDTO(updated);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'acceptation de la participation : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public ParticipationDTO rejectParticipation(Long participationid) {
        try {
            Participation participation = repository.findById(participationid)
                    .orElseThrow(() -> new EntityNotFoundException("Participation non trouvée avec l'ID : " + participationid));
            participation.setStatus(StatutParticipation.REFUSE);
            Participation updated = repository.save(participation);
            return mapper.toDTO(updated);
        } catch (Exception e) {
            System.err.println("Erreur lors du refus de la participation : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public ParticipationDTO annulerParticipation(Long participationid) {
        try {
            Optional<Participation> optionalParticipation = repository.findById(participationid);
            if (optionalParticipation.isPresent()) {
                Participation participation = optionalParticipation.get();
                participation.setStatus(StatutParticipation.ANNULER);
                Participation updated = repository.save(participation);
                return mapper.toDTO(updated);
            } else {
                throw new EntityNotFoundException("Participation non trouvée avec l'ID : " + participationid);
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de l'annulation de la participation : " + e.getMessage());
            throw e;
        }
    }
}