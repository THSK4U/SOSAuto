package com.sosauto_backend.model.Mapper;

import com.sosauto_backend.model.Dto.MecanicienDTO;
import com.sosauto_backend.model.Entity.Mecanicien;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MecanicienMapper {

    Mecanicien toEntity(MecanicienDTO dto);
    MecanicienDTO toDTO(Mecanicien entity);
    List<MecanicienDTO> toDTOList(List<Mecanicien> All);
    List<Mecanicien> toEntityList(List<MecanicienDTO> AllDTOs);
}
