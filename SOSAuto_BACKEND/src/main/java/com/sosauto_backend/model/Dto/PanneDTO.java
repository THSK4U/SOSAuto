package com.sosauto_backend.model.Dto;


import lombok.Data;

import java.util.List;

@Data
public class PanneDTO {

    private Long id;
    private String nom;
    private String description;
    private List<DemandeDepannageDTO> ticketSupports;
}
