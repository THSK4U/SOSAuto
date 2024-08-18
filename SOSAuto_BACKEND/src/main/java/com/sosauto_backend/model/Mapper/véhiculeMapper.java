package com.sosauto_backend.model.Mapper;

import com.sosauto_backend.model.Dto.VéhiculeDTO;
import com.sosauto_backend.model.Entity.Véhicule;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface véhiculeMapper {

    Véhicule toEntity(VéhiculeDTO DTO);
    VéhiculeDTO toDTO(Véhicule entity);
    List<VéhiculeDTO> toDTOList(List<Véhicule> All);
    List<Véhicule> toEntityList(List<VéhiculeDTO> AllDTOs);
}
