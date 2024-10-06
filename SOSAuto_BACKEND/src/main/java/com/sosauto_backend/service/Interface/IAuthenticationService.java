package com.sosauto_backend.service.Interface;


import com.sosauto_backend.model.dto.AdministrateurDTO;
import com.sosauto_backend.model.dto.AutomobilisteDTO;
import com.sosauto_backend.model.dto.MecanicienDTO;
import com.sosauto_backend.model.dto.PersonneDTO;
import com.sosauto_backend.model.entity.*;

public interface IAuthenticationService {

    AuthResponse registerAutomobiliste(AutomobilisteDTO request);

    AuthResponse registerMecanicien(MecanicienDTO request);

    AuthResponse registerAdmin(AdministrateurDTO request);

    AuthResponse authenticate(PersonneDTO request);
}