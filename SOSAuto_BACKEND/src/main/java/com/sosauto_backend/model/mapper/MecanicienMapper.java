package com.sosauto_backend.model.mapper;

import com.sosauto_backend.model.dto.MecanicienDTO;
import com.sosauto_backend.model.entity.Mecanicien;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MecanicienMapper {

    Mecanicien toEntity(MecanicienDTO dto);
    MecanicienDTO toDTO(Mecanicien entity);
    List<MecanicienDTO> toDTOList(List<Mecanicien> all);
    List<Mecanicien> toEntityList(List<MecanicienDTO> alldtos);
}
