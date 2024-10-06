package com.sosauto_backend.service;

import com.sosauto_backend.model.dto.DemandeDepannageDTO;
import com.sosauto_backend.model.entity.DemandeDepannage;
import com.sosauto_backend.model.mapper.DemandeDepannageMapper;
import com.sosauto_backend.respository.DemandeDepannageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DemandeServiceTest {

    @Mock
    private DemandeDepannageRepository repository;

    @InjectMocks
    private DemandeService service;

    @Mock
    private DemandeDepannageMapper mapper;

    @Test
    void creer() {
        DemandeDepannageDTO demandeDepannageDTO = new DemandeDepannageDTO();
        DemandeDepannage demandeDepannage = new DemandeDepannage();

        when(mapper.toEntity(demandeDepannageDTO)).thenReturn(demandeDepannage);
        when(repository.save(demandeDepannage)).thenReturn(demandeDepannage);
        when(mapper.toDTO(demandeDepannage)).thenReturn(demandeDepannageDTO);

        DemandeDepannageDTO result = service.creer(demandeDepannageDTO);

        assertNotNull(result);
        assertEquals(demandeDepannageDTO, result);
        verify(mapper, times(1)).toEntity(demandeDepannageDTO);
        verify(repository, times(1)).save(demandeDepannage);
        verify(mapper, times(1)).toDTO(demandeDepannage);
    }

    // Tests the retrieval of a specific demand by ID
    @Test
    void getById() {
        DemandeDepannageDTO demandeDepannageDTO = new DemandeDepannageDTO();
        DemandeDepannage demandeDepannage = new DemandeDepannage();

        when(repository.findById(1L)).thenReturn(Optional.of(demandeDepannage));
        when(mapper.toDTO(demandeDepannage)).thenReturn(demandeDepannageDTO);

        DemandeDepannageDTO result = service.getById(1L);

        assertNotNull(result);
        assertEquals(demandeDepannageDTO, result);
        verify(repository, times(1)).findById(1L);
        verify(mapper, times(1)).toDTO(demandeDepannage);
    }

    @Test
    void voirTous() {
        DemandeDepannage demande = new DemandeDepannage();

        when(repository.findAll()).thenReturn(Collections.singletonList(demande));

        List<DemandeDepannageDTO> tachesList = service.voirTous();

        assertNotNull(tachesList);

        verify(repository, times(1)).findAll();
    }

    @Test
    void supprimer() {
        service.supprimer(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}