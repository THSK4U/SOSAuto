package com.sosauto_backend.respository;


import com.sosauto_backend.model.Dto.PanneDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanneRepository extends JpaRepository<PanneDTO, Long> {

}
