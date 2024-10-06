package com.sosauto_backend.model.mapper;

import com.sosauto_backend.model.dto.DemandeDepannageDTO;
import com.sosauto_backend.model.entity.DemandeDepannage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DemandeDepannageMapper {

    DemandeDepannage toEntity(DemandeDepannageDTO dto);
    DemandeDepannageDTO toDTO(DemandeDepannage entity);
    List<DemandeDepannageDTO> toDTOList(List<DemandeDepannage> all);
    List<DemandeDepannage> toEntityList(List<DemandeDepannageDTO> alldtos);
}
