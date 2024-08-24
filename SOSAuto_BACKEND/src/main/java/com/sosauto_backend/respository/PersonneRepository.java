package com.sosauto_backend.respository;

import com.sosauto_backend.model.Dto.PersonneDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<PersonneDTO, Integer> {

}