package com.sosauto_backend.service;

import com.sosauto_backend.model.dto.DemandeDepannageDTO;
import com.sosauto_backend.model.entity.DemandeDepannage;
import com.sosauto_backend.model.enums.EtatPanne;
import com.sosauto_backend.model.mapper.DemandeDepannageMapper;
import com.sosauto_backend.respository.DemandeDepannageRepository;
import com.sosauto_backend.service.Interface.IDemandeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DemandeService implements IDemandeService {

    @Autowired
    private DemandeDepannageMapper mapper;

    @Autowired
    private DemandeDepannageRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(DemandeService.class);

    @Override
    public DemandeDepannageDTO creer(DemandeDepannageDTO demandedepannage) {
        try {
            DemandeDepannage demandedepannages = mapper.toEntity(demandedepannage);
            demandedepannages.setEtat(EtatPanne.A_FAIRE);
            DemandeDepannage saved = repository.save(demandedepannages);
            return mapper.toDTO(saved);
        } catch (Exception e) {
            logger.error("Error creating breakdown request: {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public DemandeDepannageDTO getById(Long id) {
        try {
            Optional<DemandeDepannage> demandedepannage = repository.findById(id);
            return demandedepannage.map(mapper::toDTO).orElse(null);
        } catch (Exception e) {
            logger.error("Error getting breakdown request by ID: {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<DemandeDepannageDTO> getALLByAutomobiliste(Long id) {
        try {
            List<DemandeDepannage> demandedepannage = repository.getALLByAutomobiliste_Personneid(id);
            return demandedepannage.stream()
                    .map(mapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("Error getting breakdown requests by automobilist ID: {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public DemandeDepannageDTO terminerDemande(Long demandeid) {
        try {
            DemandeDepannage demande = repository.findById(demandeid)
                    .orElseThrow(() -> new EntityNotFoundException("Demande de panne non trouvée avec l'ID : " + demandeid));
            demande.setEtat(EtatPanne.TERMINE);
            DemandeDepannage updated = repository.save(demande);
            return mapper.toDTO(updated);
        } catch (Exception e) {
            logger.error("Erreur lors de la terminaison de la demande : {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<DemandeDepannageDTO> voirTous() {
        try {
            List<DemandeDepannage> demandedepannage = repository.findAll();
            return demandedepannage.stream()
                    .map(mapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("Error getting all breakdown requests: {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public DemandeDepannageDTO mettreAJour(Long id, DemandeDepannageDTO dto) {
        try {
            Optional<DemandeDepannage> optional = repository.findById(id);
            if (optional.isPresent()) {
                DemandeDepannage demandedepannage = optional.get();
                demandedepannage.setLongitude(dto.getLongitude());
                demandedepannage.setLatitude(dto.getLatitude());
                demandedepannage.setEtat(dto.getEtat());
                demandedepannage.setMecanicien(dto.getMecanicien());
                demandedepannage.setPanne(dto.getPanne());
                demandedepannage.setDescription(dto.getDescription());

                DemandeDepannage updated = repository.save(demandedepannage);
                return mapper.toDTO(updated);
            } else {
                throw new EntityNotFoundException("DemandeDepannage with ID " + id + " not found");
            }
        } catch (Exception e) {
            logger.error("Error updating breakdown request: {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void supprimer(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            logger.error("Error deleting breakdown request: {}", e.getMessage(), e);
            throw e;
        }
    }
}