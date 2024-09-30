package com.sosauto_backend.model.Dto;

import com.sosauto_backend.model.Entity.DemandeDepannage;
import lombok.Data;

import java.util.List;


@Data
public class AutomobilisteDTO extends PersonneDTO {

    private List<VehiculeDTO> vehicules;
    private List<DemandeDepannage> demandeDepannage;

}
