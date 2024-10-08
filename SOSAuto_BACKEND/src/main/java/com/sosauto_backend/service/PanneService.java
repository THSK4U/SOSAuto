package com.sosauto_backend.service;

import com.sosauto_backend.exception.CustomServiceException;
import com.sosauto_backend.model.dto.PanneDTO;
import com.sosauto_backend.model.entity.Panne;
import com.sosauto_backend.model.mapper.PanneMapper;
import com.sosauto_backend.respository.PanneRepository;
import com.sosauto_backend.service.Interface.IPanneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PanneService implements IPanneService {

    @Autowired
    private PanneMapper mapper;

    @Autowired
    private PanneRepository repository;


    @Override
    public PanneDTO creer(PanneDTO panne) {
        try {
            Panne pannes = mapper.toEntity(panne);
            Panne saved = repository.save(pannes);
            return mapper.toDTO(saved);
        } catch (Exception e) {
            throw new CustomServiceException("Erreur lors de la création de la panne : ", e);
        }
    }

    @Override
    public PanneDTO getById(Long id) {
        try {
            Optional<Panne> panne = repository.findById(id);
            return panne.map(mapper::toDTO).orElse(null);
        } catch (Exception e) {
            throw new CustomServiceException("Erreur lors de la récupération de la panne", e);

        }
    }

    @Override
    public List<PanneDTO> voirTous() {
        try {
            List<Panne> panne = repository.findAll();
            return panne.stream()
                    .map(mapper::toDTO)
                    .toList();
        } catch (Exception e) {
            throw new CustomServiceException("Erreur lors de la récupération de toutes les pannes : ", e);
        }
    }

    @Override
    public PanneDTO mettreAJour(Long id, PanneDTO dto) {
        try {
            Optional<Panne> optional = repository.findById(id);
            if (optional.isPresent()) {
                Panne panne = optional.get();
                panne.setNom(dto.getNom());
                panne.setDescription(dto.getDescription());

                Panne updated = repository.save(panne);
                return mapper.toDTO(updated);
            } else {
                throw new CustomServiceException("Panne with ID " + id + " not found.", null);
            }
        } catch (Exception e) {
            throw new CustomServiceException("Erreur lors de la mise à jour de la panne : ", e);
        }
    }

    @Override
    public void supprimer(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new CustomServiceException("Erreur lors de la suppression de la panne : ", e);
        }
    }
}