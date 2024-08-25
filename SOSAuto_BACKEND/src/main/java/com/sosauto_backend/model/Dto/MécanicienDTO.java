package com.sosauto_backend.model.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;


@Data
public class MécanicienDTO extends PersonneDTO {
    @JsonIgnore
    private List<DemandeDepannageDTO> tickets;
}
