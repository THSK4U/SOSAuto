package com.sosauto_backend.service;

import com.sosauto_backend.model.dto.AutomobilisteDTO;
import com.sosauto_backend.model.entity.AuthResponse;
import com.sosauto_backend.model.entity.Automobiliste;
import com.sosauto_backend.model.mapper.AutomobilisteMapper;
import com.sosauto_backend.respository.AutomobilisteRepository;
import com.sosauto_backend.service.Interface.IAuthenticationService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class AutomobilisteServiceTest {


    @Mock
    private AutomobilisteRepository repository;

    @Mock
    private AutomobilisteMapper mapper;

    @Mock
    private IAuthenticationService authenticationService;

    @InjectMocks
    private AutomobilisteService service;

    public AutomobilisteServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void creer() {
        AutomobilisteDTO automobilisteDTO = new AutomobilisteDTO();
        AuthResponse authResponse = new AuthResponse("token", "message");

        when(authenticationService.registerAutomobiliste(automobilisteDTO)).thenReturn(authResponse);

        AuthResponse result = service.creer(automobilisteDTO);

        assertNotNull(result);
        assertEquals(authResponse, result);
    }

    @Test
    void getById() {
        Long id = 1L;
        Automobiliste automobiliste = new Automobiliste();
        AutomobilisteDTO automobilisteDTO = new AutomobilisteDTO();

        when(repository.findById(id)).thenReturn(Optional.of(automobiliste));
        when(mapper.toDTO(automobiliste)).thenReturn(automobilisteDTO);

        AutomobilisteDTO result = service.getById(id);

        assertNotNull(result);
        assertEquals(automobilisteDTO, result);
    }

    @Test
    void voirTous() {
        List<Automobiliste> automobilistes = new ArrayList<>();
        AutomobilisteDTO dto1 = new AutomobilisteDTO();
        automobilistes.add(mapper.toEntity(dto1));

        when(repository.findAll()).thenReturn(automobilistes);
        when(mapper.toDTO(automobilistes.get(0))).thenReturn(dto1);

        List<AutomobilisteDTO> result = service.voirTous();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.contains(dto1));
    }

    @Test
    void supprimer() {
        Long id = 1L;
        service.supprimer(id);
    }
}