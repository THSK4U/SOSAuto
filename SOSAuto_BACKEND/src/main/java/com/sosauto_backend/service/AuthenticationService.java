package com.sosauto_backend.service;


import com.sosauto_backend.model.Dto.AdministrateurDTO;
import com.sosauto_backend.model.Dto.AutomobilisteDTO;
import com.sosauto_backend.model.Dto.MécanicienDTO;
import com.sosauto_backend.model.Dto.PersonneDTO;
import com.sosauto_backend.model.Entity.*;
import com.sosauto_backend.model.Enum.Disponibilite;
import com.sosauto_backend.model.Enum.Role;
import com.sosauto_backend.respository.AdministrateurRepository;
import com.sosauto_backend.respository.AutomobilisteRepository;
import com.sosauto_backend.respository.MécanicienRepository;
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
    private final PersonneRepository Persrepository;
    private final AutomobilisteRepository AutoRepository;
    private final MécanicienRepository MechRepository;
    private final AdministrateurRepository administrateurRepository;
//

    //
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthResponse registerAutomobiliste(AutomobilisteDTO request) {
        if (AutoRepository.findBynumTelephone(request.getNumTelephone()).isPresent()) {
            return new AuthResponse(null, "Numéro de téléphone déjà existant");
        }

        Automobiliste auto = new Automobiliste();

        auto.setNom(request.getNom());
        auto.setPrenom(request.getPrenom());
        auto.setEmail(request.getEmail());
        auto.setPassword(passwordEncoder.encode(request.getPassword()));
        auto.setRole(Role.AUTO);
        auto.setNationalIdCardUrl(request.getNationalIdCardUrl());
        auto.setNumTelephone(request.getNumTelephone());

        AutoRepository.save(auto);

        return new AuthResponse(jwtService.generateToken(auto), "L'inscription de l'automobiliste a été réussie");
    }

    @Override
    public AuthResponse registerMecanicien(MécanicienDTO request) {
        if (MechRepository.findBynumTelephone(request.getNumTelephone()).isPresent()) {
            return new AuthResponse(null, "Numéro de téléphone déjà existant");
        }

        Mécanicien Mech = new Mécanicien();

        Mech.setNom(request.getNom());
        Mech.setPrenom(request.getPrenom());
        Mech.setEmail(request.getEmail());
        Mech.setPassword(passwordEncoder.encode(request.getPassword()));
        Mech.setRole(Role.MECA);
        Mech.setNationalIdCardUrl(request.getNationalIdCardUrl());
        Mech.setNumTelephone(request.getNumTelephone());
        Mech.setDisponible(Disponibilite.INDISPONIBLE);
        Mech.setLatitude(request.getLatitude());
        Mech.setLongitude(request.getLongitude());
        Mech.setProofOfProfessionUrl(request.getProofOfProfessionUrl());

        MechRepository.save(Mech);

        return new AuthResponse(jwtService.generateToken(Mech), "L'inscription de l'automobiliste a été réussie");

    }

    @Override
    public AuthResponse registerAdmin(AdministrateurDTO request) {
        Administrateur admin = new Administrateur();

        admin.setUsername(request.getUsername());
        admin.setPassword(passwordEncoder.encode(request.getPassword()));
        admin.setRole(Role.ADMIN);

        administrateurRepository.save(admin);
        return new AuthResponse(jwtService.generateToken(admin), "L'inscription de l'administrateur a été spécie");
    }

    @Override
    public AuthResponse authenticate(PersonneDTO request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getNumTelephone(),
                        request.getPassword()
                )
        );

        Personne user = Persrepository.findBynumTelephone(request.getNumTelephone())
                .orElseThrow(() -> new RuntimeException("User not found with phone number: " + request.getNumTelephone()));

        // Generate JWT token for the authenticated user
        return new AuthResponse(jwtService.generateToken(user), "Authentification réussie");
    }
}
