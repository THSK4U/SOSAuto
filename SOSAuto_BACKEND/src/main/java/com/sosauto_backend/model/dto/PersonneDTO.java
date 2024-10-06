package com.sosauto_backend.model.dto;

import com.sosauto_backend.model.enums.Role;
import lombok.Data;

@Data
public class PersonneDTO {

    private Long personneid;
    private String nom;
    private String prenom;
    private String email;
    private String nationalIdCardUrl;
    private String numTelephone;
    private String password;
    private Role role;
}
