package com.sosauto_backend.respository;

import com.sosauto_backend.model.Entity.DemandeDepannage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeDepannageRepository extends JpaRepository<DemandeDepannage, Long> {
}
