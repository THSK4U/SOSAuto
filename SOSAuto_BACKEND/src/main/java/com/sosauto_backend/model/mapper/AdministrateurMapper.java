package com.sosauto_backend.model.mapper;

import com.sosauto_backend.model.dto.AdministrateurDTO;
import com.sosauto_backend.model.entity.Administrateur;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdministrateurMapper {

    Administrateur toEntity(AdministrateurDTO dto);
    AdministrateurDTO toDTO(Administrateur entity);
    List<AdministrateurDTO> toDTOList(List<Administrateur> all);
    List<Administrateur> toEntityList(List<AdministrateurDTO> alldtos);
}
