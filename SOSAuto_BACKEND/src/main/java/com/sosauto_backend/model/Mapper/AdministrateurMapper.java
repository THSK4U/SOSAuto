package com.sosauto_backend.model.Mapper;

import com.sosauto_backend.model.Dto.AdministrateurDTO;
import com.sosauto_backend.model.Entity.Administrateur;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdministrateurMapper {

    Administrateur toEntity(AdministrateurDTO dto);
    AdministrateurDTO toDTO(Administrateur entity);
    List<AdministrateurDTO> toDTOList(List<Administrateur> all);
    List<Administrateur> toEntityList(List<AdministrateurDTO> alldtos);
}
