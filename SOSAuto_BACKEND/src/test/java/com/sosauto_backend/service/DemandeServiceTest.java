package com.sosauto_backend.service;

import com.sosauto_backend.model.Dto.DemandeDepannageDTO;
import com.sosauto_backend.model.Entity.DemandeDepannage;
import com.sosauto_backend.model.Enum.EtatPanne;
import com.sosauto_backend.model.Mapper.DemandeDepannageMapper;
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
    private DemandeDepannageRepository Repository;

    @InjectMocks
    private DemandeService Service;

    @Mock
    private DemandeDepannageMapper mapper;

    @Test
    void creer() {
        DemandeDepannageDTO demandeDepannageDTO = new DemandeDepannageDTO();
        DemandeDepannage demandeDepannage = new DemandeDepannage();

        when(mapper.toEntity(demandeDepannageDTO)).thenReturn(demandeDepannage);
        when(Repository.save(demandeDepannage)).thenReturn(demandeDepannage);
        when(mapper.toDTO(demandeDepannage)).thenReturn(demandeDepannageDTO);

        DemandeDepannageDTO result = Service.creer(demandeDepannageDTO);

        assertNotNull(result);
        assertEquals(demandeDepannageDTO, result);
        verify(mapper, times(1)).toEntity(demandeDepannageDTO);
        verify(Repository, times(1)).save(demandeDepannage);
        verify(mapper, times(1)).toDTO(demandeDepannage);
    }

    // Tests the retrieval of a specific demand by ID
    @Test
    void getById() {
        DemandeDepannageDTO demandeDepannageDTO = new DemandeDepannageDTO();
        DemandeDepannage demandeDepannage = new DemandeDepannage();

        when(Repository.findById(1L)).thenReturn(Optional.of(demandeDepannage));
        when(mapper.toDTO(demandeDepannage)).thenReturn(demandeDepannageDTO);

        DemandeDepannageDTO result = Service.getById(1L);

        assertNotNull(result);
        assertEquals(demandeDepannageDTO, result);
        verify(Repository, times(1)).findById(1L);
        verify(mapper, times(1)).toDTO(demandeDepannage);
    }

    @Test
    void voirTous() {
        DemandeDepannage demande = new DemandeDepannage();

        when(Repository.findAll()).thenReturn(Collections.singletonList(demande));

        List<DemandeDepannageDTO> tachesList = Service.voirTous();

        assertNotNull(tachesList);

        verify(Repository, times(1)).findAll();
    }

    @Test
    void supprimer() {
        Service.supprimer(1L);

        verify(Repository, times(1)).deleteById(1L);
    }
}