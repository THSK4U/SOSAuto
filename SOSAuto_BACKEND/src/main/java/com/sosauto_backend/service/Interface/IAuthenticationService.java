package com.sosauto_backend.service.Interface;


import com.sosauto_backend.model.Entity.*;

public interface IAuthenticationService {

    AuthResponse registerAutomobiliste(Automobiliste request);

    AuthResponse registerMecanicien(Mécanicien request);

    AuthResponse registerAdmin(Administrateur request);

    AuthResponse authenticate(Personne request);
}