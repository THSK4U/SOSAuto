package com.sosauto_backend.model.mapper;

import com.sosauto_backend.model.dto.VehiculeDTO;
import com.sosauto_backend.model.entity.Vehicule;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface vehiculeMapper {

    Vehicule toEntity(VehiculeDTO dto);
    VehiculeDTO toDTO(Vehicule entity);
    List<VehiculeDTO> toDTOList(List<Vehicule> all);
    List<Vehicule> toEntityList(List<VehiculeDTO> alldtos);
}
