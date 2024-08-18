package com.sosauto_backend.model.Mapper;

import com.sosauto_backend.model.Dto.AutomobilisteDTO;
import com.sosauto_backend.model.Entity.Automobiliste;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AutomobilisteMapper {

    Automobiliste toEntity(AutomobilisteDTO DTO);
    AutomobilisteDTO toDTO(Automobiliste entity);
    List<AutomobilisteDTO> toDTOList(List<Automobiliste> All);
    List<Automobiliste> toEntityList(List<AutomobilisteDTO> AllDTOs);
}
