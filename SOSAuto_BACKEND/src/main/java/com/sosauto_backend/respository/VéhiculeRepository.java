package com.sosauto_backend.respository;


import com.sosauto_backend.model.Dto.VéhiculeDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VéhiculeRepository extends JpaRepository<VéhiculeDTO, Long> {
}
