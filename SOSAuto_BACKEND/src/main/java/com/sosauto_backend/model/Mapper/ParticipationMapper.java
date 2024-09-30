package com.sosauto_backend.model.Mapper;

import com.sosauto_backend.model.Dto.ParticipationDTO;
import com.sosauto_backend.model.Entity.Participation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParticipationMapper {
    Participation toEntity(ParticipationDTO dto);
    ParticipationDTO toDTO(Participation entity);
    List<ParticipationDTO> toDTOList(List<Participation> all);
    List<Participation> toEntityList(List<ParticipationDTO> alldto);

}
