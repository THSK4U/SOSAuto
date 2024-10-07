package com.sosauto_backend.service;

import com.sosauto_backend.model.dto.AutomobilisteDTO;
import com.sosauto_backend.model.dto.PersonneDTO;
import com.sosauto_backend.model.entity.*;
import com.sosauto_backend.model.enums.Role;
import com.sosauto_backend.respository.AutomobilisteRepository;
import com.sosauto_backend.respository.PersonneRepository;
import com.sosauto_backend.service.securitySevice.JwtService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class AuthenticationServiceTest {

    @Mock
    private AutomobilisteRepository autoRepository;

    @Mock
    private PersonneRepository personneRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private AuthenticationService service;

    public AuthenticationServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerAutomobiliste() {

        AutomobilisteDTO request = new AutomobilisteDTO();
        request.setNumTelephone("1234567890");
        request.setNom("Nom");
        request.setPrenom("Prenom");
        request.setEmail("test@example.com");
        request.setPassword("password");
        request.setNationalIdCardUrl("url");

        when(autoRepository.findBynumTelephone(request.getNumTelephone())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(request.getPassword())).thenReturn("encodedPassword");
        when(jwtService.generateToken(any(Automobiliste.class))).thenReturn("token");

        AuthResponse result = service.registerAutomobiliste(request);

        assertNotNull(result);
        assertEquals("token", result.getJwt());
        assertEquals("L'inscription de l'automobiliste a été réussie", result.getMessage());

    }

    @Test
    void authenticate() {
        PersonneDTO request = new PersonneDTO();
        request.setNumTelephone("1234567890");
        request.setPassword("password");

        Personne personne = new Personne();
        personne.setRole(Role.AUTO);
        personne.setNumTelephone("1234567890");

        when(personneRepository.findBynumTelephone(request.getNumTelephone())).thenReturn(Optional.of(personne));
        when(jwtService.generateToken(any(Personne.class))).thenReturn("token");

        AuthResponse result = service.authenticate(request);

        assertNotNull(result);
        assertEquals("token", result.getJwt());
        assertEquals("Authentification réussie", result.getMessage());

    }

}