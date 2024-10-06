package com.sosauto_backend.model.mapper;


import com.sosauto_backend.model.dto.PersonneDTO;
import com.sosauto_backend.model.entity.Personne;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonneMapper {

    Personne toEntity(PersonneDTO dto);
    PersonneDTO toDTO(Personne entity);
    List<PersonneDTO> toDTOList(List<Personne> all);
    List<Personne> toEntityList(List<PersonneDTO> alldtos);
}
