package com.sosauto_backend.model.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sosauto_backend.model.Enum.Disponibilite;
import lombok.Data;

import java.util.List;


@Data
public class MecanicienDTO extends PersonneDTO {
    private Double latitude;
    private Double longitude;
    private String proofOfProfessionUrl;
    private Disponibilite disponible;
    @JsonIgnore
    private List<DemandeDepannageDTO> tickets;
}
