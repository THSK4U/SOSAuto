package com.sosauto_backend.service.Interface;


import com.sosauto_backend.model.Dto.PersonneDTO;

import java.util.List;

public interface IPersonneService {
    PersonneDTO create(PersonneDTO personne);
    PersonneDTO getById(Long id);
    List<PersonneDTO> getAll();
    PersonneDTO update(Long id, PersonneDTO DTO);
    void delete(Long id);
}