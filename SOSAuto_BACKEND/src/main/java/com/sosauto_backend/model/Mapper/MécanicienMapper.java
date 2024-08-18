package com.sosauto_backend.model.Mapper;

import com.sosauto_backend.model.Dto.MécanicienDTO;
import com.sosauto_backend.model.Entity.Mécanicien;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MécanicienMapper {

    Mécanicien toEntity(MécanicienDTO DTO);
    MécanicienDTO toDTO(Mécanicien entity);
    List<MécanicienDTO> toDTOList(List<Mécanicien> All);
    List<Mécanicien> toEntityList(List<MécanicienDTO> AllDTOs);
}
