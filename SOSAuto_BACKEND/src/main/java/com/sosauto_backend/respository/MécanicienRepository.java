package com.sosauto_backend.respository;


import com.sosauto_backend.model.Entity.Mécanicien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MécanicienRepository extends JpaRepository<Mécanicien,Long> {

}
