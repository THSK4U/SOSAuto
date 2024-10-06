package com.sosauto_backend.model.mapper;

import com.sosauto_backend.model.dto.AutomobilisteDTO;
import com.sosauto_backend.model.entity.Automobiliste;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AutomobilisteMapper {

    Automobiliste toEntity(AutomobilisteDTO dto);
    AutomobilisteDTO toDTO(Automobiliste entity);
    List<AutomobilisteDTO> toDTOList(List<Automobiliste> all);
    List<Automobiliste> toEntityList(List<AutomobilisteDTO> alldtos);
}
