package com.sosauto_backend.respository;


import com.sosauto_backend.model.Entity.Véhicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VéhiculeRepository extends JpaRepository<Véhicule, Long> {
}
