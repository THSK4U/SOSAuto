package com.sosauto_backend.service;

import com.sosauto_backend.model.dto.PersonneDTO;
import com.sosauto_backend.model.entity.Personne;
import com.sosauto_backend.model.mapper.PersonneMapper;
import com.sosauto_backend.respository.PersonneRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonneServiceTest {

    @Mock
    private PersonneRepository repository;

    @Mock
    private PersonneMapper mapper;

    @InjectMocks
    private PersonneService service;

    public PersonneServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void creer() {
        PersonneDTO personneDTO = new PersonneDTO();
        Personne personne = new Personne();

        when(mapper.toEntity(personneDTO)).thenReturn(personne);
        when(repository.save(personne)).thenReturn(personne);
        when(mapper.toDTO(personne)).thenReturn(personneDTO);

        PersonneDTO result = service.creer(personneDTO);

        assertNotNull(result);
        assertEquals(personneDTO, result);

    }

    @Test
    void getById() {
        PersonneDTO personneDTO = new PersonneDTO();
        Personne personne = new Personne();

        when(repository.findById(1L)).thenReturn(Optional.of(personne));
        when(mapper.toDTO(personne)).thenReturn(personneDTO);

        PersonneDTO result = service.getById(1L);

        assertNotNull(result);
        assertEquals(personneDTO, result);

    }

    @Test
    void voirTous() {
        Personne personne = new Personne();
        PersonneDTO personneDTO = new PersonneDTO();

        when(repository.findAll()).thenReturn(Collections.singletonList(personne));
        when(mapper.toDTO(personne)).thenReturn(personneDTO);

        List<PersonneDTO> result = service.voirTous();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void mettreAJour() {
        PersonneDTO personneDTO = new PersonneDTO();
        personneDTO.setPersonneid(1L);
        Personne personne = new Personne();
        personne.setPersonneid(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(personne));
        when(mapper.toEntity(personneDTO)).thenReturn(personne);
        when(repository.save(personne)).thenReturn(personne);
        when(mapper.toDTO(personne)).thenReturn(personneDTO);

        PersonneDTO result = service.mettreAJour(1L, personneDTO);

        assertNotNull(result);
        assertEquals(personneDTO, result);

    }

    @Test
    void supprimer() {
        service.supprimer(1L);
    }
}
