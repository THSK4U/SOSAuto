package com.sosauto_backend.model.Dto;

import lombok.Data;

import java.util.List;


@Data
public class AutomobilisteDTO extends PersonneDTO {

    private List<VéhiculeDTO> véhicules;
}