package com.sosauto_backend.controller;

import com.sosauto_backend.controller.api.IParticipationApi;
import com.sosauto_backend.model.Dto.ParticipationDTO;
import com.sosauto_backend.model.Entity.Participation;
import com.sosauto_backend.service.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParticipationController implements IParticipationApi {
    @Autowired
    private ParticipationService Service;
    @Override
    public ParticipationDTO creerParticipation(ParticipationDTO Participation) {
        return Service.creer(Participation);
    }

    @Override
    public void supprimerParticipation(Long id) {
        Service.supprimer(id);
    }

    @Override
    public List<ParticipationDTO> getAllParticipation() {
        return Service.voirTous();
    }

    @Override
    public ParticipationDTO mettreAjourParticipation(Long id, ParticipationDTO Participation) {
        return Service.mettreAJour(id, Participation);
    }

    @Override
    public ParticipationDTO getParticipationById(Long id) {
        return Service.getById(id);
    }

    @Override
    public List<ParticipationDTO> getALLParticipationByIdMecanicien(Long id) {
        return Service.getByMecanicienId(id);
    }

    @Override
    public ResponseEntity<ParticipationDTO> acceptParticipation(Long participationId) {
        ParticipationDTO participation = Service.acceptParticipation(participationId);
        return ResponseEntity.ok(participation);
    }

    @Override
    public ResponseEntity<ParticipationDTO> rejectParticipation(Long participationId) {
        ParticipationDTO participation = Service.rejectParticipation(participationId);
        return ResponseEntity.ok(participation);
    }
}
