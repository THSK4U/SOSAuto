package com.sosauto_backend.model.Mapper;

import com.sosauto_backend.model.Dto.PanneDTO;
import com.sosauto_backend.model.Entity.Panne;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PanneMapper {

    Panne toEntity(PanneDTO dto);
    PanneDTO toDTO(Panne entity);
    List<PanneDTO> toDTOList(List<Panne> all);
    List<Panne> toEntityList(List<PanneDTO> alldtos);
}
