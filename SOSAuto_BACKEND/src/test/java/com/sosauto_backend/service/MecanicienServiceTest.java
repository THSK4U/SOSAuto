package com.sosauto_backend.service;

import com.sosauto_backend.model.dto.MecanicienDTO;
import com.sosauto_backend.model.entity.AuthResponse;
import com.sosauto_backend.model.entity.Mecanicien;
import com.sosauto_backend.model.enums.Disponibilite;
import com.sosauto_backend.model.mapper.MecanicienMapper;
import com.sosauto_backend.respository.MecanicienRepository;
import com.sosauto_backend.service.Interface.IAuthenticationService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MecanicienServiceTest {
    @Mock
    private MecanicienRepository repository;

    @Mock
    private MecanicienMapper mapper;

    @Mock
    private IAuthenticationService authenticationService;

    @InjectMocks
    private MecanicienService service;

    public MecanicienServiceTest() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void creer() {
        MecanicienDTO mecanicienDTO = new MecanicienDTO();
        AuthResponse authResponse = new AuthResponse("token", "message");

        when(authenticationService.registerMecanicien(mecanicienDTO)).thenReturn(authResponse);

        AuthResponse result = service.creer(mecanicienDTO);

        assertNotNull(result);
        assertEquals(authResponse, result);
        assertEquals(Disponibilite.INDISPONIBLE, mecanicienDTO.getDisponible());
    }

    @Test
    void getById() {
        MecanicienDTO mecanicienDTO = new MecanicienDTO();
        Mecanicien mecanicien = new Mecanicien();

        when(repository.findById(1L)).thenReturn(Optional.of(mecanicien));
        when(mapper.toDTO(mecanicien)).thenReturn(mecanicienDTO);

        MecanicienDTO result = service.getById(1L);

        assertNotNull(result);
        assertEquals(mecanicienDTO, result);

    }

    @Test
    void getDisponibilite() {
        Mecanicien mecanicien = new Mecanicien();
        MecanicienDTO mecanicienDTO = new MecanicienDTO();

        when(repository.getAllByDisponible(Disponibilite.DISPONIBLE)).thenReturn(Collections.singletonList(mecanicien));
        when(mapper.toDTO(mecanicien)).thenReturn(mecanicienDTO);

        List<MecanicienDTO> result = service.getDisponibilite();

        assertNotNull(result);
        assertEquals(1, result.size());
    }
}