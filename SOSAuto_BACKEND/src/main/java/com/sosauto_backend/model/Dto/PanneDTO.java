package com.sosauto_backend.model.Dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class PanneDTO {

    private Long id;
    private String nom;
    private String description;
    @JsonIgnore
    private List<DemandeDepannageDTO> ticketSupports;
}
