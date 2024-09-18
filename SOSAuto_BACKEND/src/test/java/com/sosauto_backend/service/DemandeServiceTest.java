package com.sosauto_backend.service;

import com.sosauto_backend.model.Dto.DemandeDepannageDTO;
import com.sosauto_backend.model.Entity.DemandeDepannage;
import com.sosauto_backend.model.Mapper.DemandeDepannageMapper;
import com.sosauto_backend.respository.DemandeDepannageRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DemandeServiceTest {

    @Mock
    private DemandeDepannageRepository Repository;

    @Mock
    private DemandeService Service;

    @Mock
    private DemandeDepannageMapper mapper;

    @Test
    void creer() {
    }

    @Test
    void getById() {
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
    void mettreAJour() {
    }

    @Test
    void supprimer() {
    }
}