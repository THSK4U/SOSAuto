package com.sosauto_backend.model.Mapper;

import com.sosauto_backend.model.Dto.VehiculeDTO;
import com.sosauto_backend.model.Entity.Vehicule;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface vehiculeMapper {

    Vehicule toEntity(VehiculeDTO dto);
    VehiculeDTO toDTO(Vehicule entity);
    List<VehiculeDTO> toDTOList(List<Vehicule> all);
    List<Vehicule> toEntityList(List<VehiculeDTO> alldtos);
}
