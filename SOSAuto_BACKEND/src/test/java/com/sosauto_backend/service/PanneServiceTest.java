package com.sosauto_backend.service;

import com.sosauto_backend.model.dto.PanneDTO;
import com.sosauto_backend.model.entity.Panne;


import com.sosauto_backend.model.mapper.PanneMapper;
import com.sosauto_backend.respository.PanneRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class PanneServiceTest {

    @Mock
    private PanneRepository repository;

    @Mock
    private PanneMapper mapper;

    @InjectMocks
    private PanneService service;

    public PanneServiceTest() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void create() {
        PanneDTO panneDTO = new PanneDTO();
        panneDTO.setNom("Test Panne");
        panneDTO.setDescription("Test Description");

        Panne panne = new Panne();
        panne.setNom("Test Panne");
        panne.setDescription("Test Description");

        when(mapper.toEntity(panneDTO)).thenReturn(panne);
        when(repository.save(panne)).thenReturn(panne);
        when(mapper.toDTO(panne)).thenReturn(panneDTO);

        PanneDTO result = service.creer(panneDTO);

        assertNotNull(result);
        assertEquals("Test Panne", result.getNom());
        assertEquals("Test Description", result.getDescription());
    }

    @Test
    public void getbyid() {
        Long nonExistentId = 999L;

        when(repository.findById(nonExistentId)).thenReturn(Optional.empty());

        PanneDTO result = service.getById(nonExistentId);

        assertNull(result);
    }
}