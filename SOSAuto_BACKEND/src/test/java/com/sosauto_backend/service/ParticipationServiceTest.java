package com.sosauto_backend.service;

import com.sosauto_backend.model.Dto.ParticipationDTO;
import com.sosauto_backend.model.Entity.Participation;
import com.sosauto_backend.model.Mapper.ParticipationMapper;
import com.sosauto_backend.respository.ParticipationRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ParticipationServiceTest {

    @Mock
    private ParticipationRepository repository;

    @Mock
    private ParticipationMapper mapper;

    @InjectMocks
    private ParticipationService service;

    public ParticipationServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void creer() {
        ParticipationDTO dto = new ParticipationDTO();
        Participation participation = new Participation();

        when(mapper.toEntity(dto)).thenReturn(participation);
        when(repository.save(participation)).thenReturn(participation);
        when(mapper.toDTO(participation)).thenReturn(dto);

        ParticipationDTO result = service.creer(dto);

        assertNotNull(result);
        assertEquals(dto, result);
        verify(mapper, times(1)).toEntity(dto);
        verify(repository, times(1)).save(participation);
        verify(mapper, times(1)).toDTO(participation);

    }


    @Test
    void supprimerByDemande() {
        Long demandeId = 1L;
        Long mecanicienId = 2L;

        doNothing().when(repository).deleteByDemande_DemandeidAndMecanicien_Personneid(demandeId, mecanicienId);

        service.supprimerByDemande(demandeId, mecanicienId);

        verify(repository, times(1)).deleteByDemande_DemandeidAndMecanicien_Personneid(demandeId, mecanicienId);
    }

    @Test
    void voirTous() {
        List<Participation> participations = Collections.singletonList(new Participation());
        when(repository.findAll()).thenReturn(participations);

        List<ParticipationDTO> dtos = service.voirTous();

        assertNotNull(dtos);
        assertEquals(participations.size(), dtos.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void getByMecanicienId() {
        Long mecanicienId = 1L;
        List<Participation> participations = Collections.singletonList(new Participation());
        when(repository.getAllByMecanicien_Personneid(mecanicienId)).thenReturn(participations);

        List<ParticipationDTO> dtos = service.getByMecanicienId(mecanicienId);

        assertNotNull(dtos);
        assertEquals(participations.size(), dtos.size());
        verify(repository, times(1)).getAllByMecanicien_Personneid(mecanicienId);
    }
}