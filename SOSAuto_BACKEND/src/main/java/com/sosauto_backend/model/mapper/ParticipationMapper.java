package com.sosauto_backend.model.mapper;

import com.sosauto_backend.model.dto.ParticipationDTO;
import com.sosauto_backend.model.entity.Participation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParticipationMapper {
    Participation toEntity(ParticipationDTO dto);
    ParticipationDTO toDTO(Participation entity);
    List<ParticipationDTO> toDTOList(List<Participation> all);
    List<Participation> toEntityList(List<ParticipationDTO> alldto);

}
