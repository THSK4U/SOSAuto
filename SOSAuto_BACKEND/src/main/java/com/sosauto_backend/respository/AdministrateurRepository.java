package com.sosauto_backend.respository;


import com.sosauto_backend.model.Dto.AdministrateurDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrateurRepository extends JpaRepository<AdministrateurDTO, Integer> {

}
