package com.sosauto_backend.model.Dto;

import com.sosauto_backend.model.Enum.Role;
import lombok.Data;

@Data
public class PersonneDTO {

    private Long personneid;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Role role;
}
