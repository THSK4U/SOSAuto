package com.sosauto_backend.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class PanneDTO {

    private Long panneid;
    private String nom;
    private String description;
    @JsonIgnore
    private List<DemandeDepannageDTO> ticketSupports;
}
