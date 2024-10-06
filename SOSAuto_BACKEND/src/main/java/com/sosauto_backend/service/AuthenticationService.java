package com.sosauto_backend.service;


import com.sosauto_backend.model.dto.*;
import com.sosauto_backend.model.entity.*;
import com.sosauto_backend.model.enums.Disponibilite;
import com.sosauto_backend.model.enums.Role;
import com.sosauto_backend.respository.AdministrateurRepository;
import com.sosauto_backend.respository.AutomobilisteRepository;
import com.sosauto_backend.respository.MecanicienRepository;
import com.sosauto_backend.respository.PersonneRepository;
import com.sosauto_backend.service.Interface.IAuthenticationService;
import com.sosauto_backend.service.securitySevice.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements IAuthenticationService {

    //DAO
    private final PersonneRepository persrepository;
    private final AutomobilisteRepository autorepository;
    private final MecanicienRepository mechrepository;
    private final AdministrateurRepository administrateurrepository;
//

    //
    private final PasswordEncoder passwordencoder;
    private final JwtService jwtservice;
    private final AuthenticationManager authenticationmanager;


    @Override
    public AuthResponse registerAutomobiliste(AutomobilisteDTO request) {
        try {
            if (autorepository.findBynumTelephone(request.getNumTelephone()).isPresent()) {
                return new AuthResponse(null, "Numéro de téléphone déjà existant");
            }

            Automobiliste auto = new Automobiliste();

            auto.setNom(request.getNom());
            auto.setPrenom(request.getPrenom());
            auto.setEmail(request.getEmail());
            auto.setPassword(passwordencoder.encode(request.getPassword()));
            auto.setRole(Role.AUTO);
            auto.setNationalIdCardUrl(request.getNationalIdCardUrl());
            auto.setNumTelephone(request.getNumTelephone());

            autorepository.save(auto);

            return new AuthResponse(jwtservice.generateToken(auto), "L'inscription de l'automobiliste a été réussie");
        } catch (Exception e) {
            System.err.println("Error registering automobilist: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public AuthResponse registerMecanicien(MecanicienDTO request) {
        try {
            if (mechrepository.findBynumTelephone(request.getNumTelephone()).isPresent()) {
                return new AuthResponse(null, "Numéro de téléphone déjà existant");
            }

            Mecanicien mech = new Mecanicien();

            mech.setNom(request.getNom());
            mech.setPrenom(request.getPrenom());
            mech.setEmail(request.getEmail());
            mech.setPassword(passwordencoder.encode(request.getPassword()));
            mech.setRole(Role.MECA);
            mech.setNationalIdCardUrl(request.getNationalIdCardUrl());
            mech.setNumTelephone(request.getNumTelephone());
            mech.setDisponible(Disponibilite.INDISPONIBLE);
            mech.setLatitude(request.getLatitude());
            mech.setLongitude(request.getLongitude());
            mech.setProofOfProfessionUrl(request.getProofOfProfessionUrl());

            mechrepository.save(mech);

            return new AuthResponse(jwtservice.generateToken(mech), "L'inscription du mécanicien a été réussie");
        } catch (Exception e) {
            System.err.println("Error registering mechanic: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public AuthResponse registerAdmin(AdministrateurDTO request) {
        try {
            Administrateur admin = new Administrateur();

            admin.setUsername(request.getUsername());
            admin.setPassword(passwordencoder.encode(request.getPassword()));
            admin.setRole(Role.ADMIN);

            administrateurrepository.save(admin);
            return new AuthResponse(jwtservice.generateToken(admin), "L'inscription de l'administrateur a été spécie");
        } catch (Exception e) {
            System.err.println("Error registering admin: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public AuthResponse authenticate(PersonneDTO request) {
        try {
            authenticationmanager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getNumTelephone(),
                            request.getPassword()
                    )
            );

            Personne user = persrepository.findBynumTelephone(request.getNumTelephone())
                    .orElseThrow(() -> new RuntimeException("User not found with phone number: " + request.getNumTelephone()));

            // Generate JWT token for the authenticated user
            return new AuthResponse(jwtservice.generateToken(user), "Authentification réussie");
        } catch (Exception e) {
            System.err.println("Error authenticating user: " + e.getMessage());
            throw e;
        }
    }
}