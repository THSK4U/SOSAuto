package com.sosauto_backend.model.Mapper;

import com.sosauto_backend.model.Dto.DemandeDepannageDTO;
import com.sosauto_backend.model.Entity.DemandeDepannage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DemandeDepannageMapper {

    DemandeDepannage toEntity(DemandeDepannageDTO dto);
    DemandeDepannageDTO toDTO(DemandeDepannage entity);
    List<DemandeDepannageDTO> toDTOList(List<DemandeDepannage> all);
    List<DemandeDepannage> toEntityList(List<DemandeDepannageDTO> alldtos);
}
