package com.sosauto_backend.service.Interface;


import com.sosauto_backend.model.Dto.AdministrateurDTO;
import com.sosauto_backend.model.Dto.AutomobilisteDTO;
import com.sosauto_backend.model.Dto.MécanicienDTO;
import com.sosauto_backend.model.Dto.PersonneDTO;
import com.sosauto_backend.model.Entity.*;

public interface IAuthenticationService {

    AuthResponse registerAutomobiliste(AutomobilisteDTO request);

    AuthResponse registerMecanicien(MécanicienDTO request);

    AuthResponse registerAdmin(AdministrateurDTO request);

    AuthResponse authenticate(PersonneDTO request);
}