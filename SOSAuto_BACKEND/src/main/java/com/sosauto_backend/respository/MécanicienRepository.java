package com.sosauto_backend.respository;


import com.sosauto_backend.model.Dto.MécanicienDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MécanicienRepository extends JpaRepository<MécanicienDTO,Long> {

}
