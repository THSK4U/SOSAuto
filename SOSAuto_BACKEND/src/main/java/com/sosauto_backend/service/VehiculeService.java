package com.sosauto_backend.service;



import com.sosauto_backend.model.dto.VehiculeDTO;
import com.sosauto_backend.model.entity.Vehicule;
import com.sosauto_backend.model.mapper.vehiculeMapper;
import com.sosauto_backend.respository.VehiculeRepository;
import com.sosauto_backend.service.Interface.IvehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculeService implements IvehiculeService {

    @Autowired
    private vehiculeMapper mapper;

    @Autowired
    private VehiculeRepository repository;

    @Override
    public VehiculeDTO creer(VehiculeDTO vehicule) {
        try {
            Vehicule entityvehicule = mapper.toEntity(vehicule);
            Vehicule saved = repository.save(entityvehicule);
            return mapper.toDTO(saved);
        } catch (Exception e) {
            System.err.println("Erreur lors de la création du véhicule : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public VehiculeDTO getById(Long id) {
        try {
            Optional<Vehicule> vehicule = repository.findById(id);
            return vehicule.map(mapper::toDTO).orElse(null);
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération du véhicule par ID : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<VehiculeDTO> voirTous() {
        try {
            List<Vehicule> vehicule = repository.findAll();
            return vehicule.stream()
                    .map(mapper::toDTO)
                    .toList();
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération de tous les véhicules : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public VehiculeDTO mettreAJour(Long id, VehiculeDTO dto) {
        try {
            Optional<Vehicule> optional = repository.findById(id);
            if (optional.isPresent()) {
                Vehicule vehicule = optional.get();
                vehicule.setAnnee(dto.getAnnee());
                vehicule.setModele(dto.getModele());
                vehicule.setCouleur(dto.getCouleur());
                vehicule.setMarque(dto.getMarque());
                vehicule.setMatricule(dto.getMatricule());

                Vehicule updated = repository.save(vehicule);
                return mapper.toDTO(updated);
            } else {
                return null; // Or throw an exception for vehicle not found
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour du véhicule : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void supprimer(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression du véhicule : " + e.getMessage());
            throw e;
        }
    }
}