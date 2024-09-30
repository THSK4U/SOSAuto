package com.sosauto_backend.controller;

import com.sosauto_backend.controller.api.IParticipationApi;
import com.sosauto_backend.model.Dto.ParticipationDTO;
import com.sosauto_backend.service.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParticipationController implements IParticipationApi {
    @Autowired
    private ParticipationService service;
    @Override
    public ResponseEntity<ParticipationDTO> creerParticipation(ParticipationDTO participation) {
        ParticipationDTO test = service.creer(participation);
        return ResponseEntity.ok(test);
    }

    @Override
    public void supprimerParticipation(Long id) {
        service.supprimer(id);
    }

    @Override
    public void supprimerParticipationByDemande(Long demandeId, Long mecanicienId) { service.supprimerByDemande(demandeId, mecanicienId); }

    @Override
    public List<ParticipationDTO> getAllParticipation() {
        return service.voirTous();
    }

    @Override
    public ParticipationDTO mettreAjourParticipation(Long id, ParticipationDTO participation) {
        return service.mettreAJour(id, participation);
    }

    @Override
    public ParticipationDTO getParticipationById(Long id) {
        return service.getById(id);
    }

    @Override
    public List<ParticipationDTO> getALLParticipationByIdMecanicien(Long id) {
        return service.getByMecanicienId(id);
    }

    @Override
    public List<ParticipationDTO> getALLParticipationByIdAutomobilist(Long id) {
        return service.getByDemande_AutomobilistId(id);
    }

    @Override
    public List<ParticipationDTO> getALLParticipationByIDDemande(Long id) {
        return service.getALLByDemandeID(id);
    }

    @Override
    public ResponseEntity<ParticipationDTO> acceptParticipation(Long participationId) {
        ParticipationDTO participation = service.acceptParticipation(participationId);
        return ResponseEntity.ok(participation);
    }

    @Override
    public ResponseEntity<ParticipationDTO> rejectParticipation(Long participationId) {
        ParticipationDTO participation = service.rejectParticipation(participationId);
        return ResponseEntity.ok(participation);
    }

    @Override
    public ParticipationDTO annulerParticipation(Long id) {
        return service.annulerParticipation(id);
    }
}
