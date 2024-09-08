package com.sosauto_backend.respository;


import com.sosauto_backend.model.Entity.Mécanicien;
import com.sosauto_backend.model.Enum.Disponibilite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MécanicienRepository extends JpaRepository<Mécanicien,Long> {

    List<Mécanicien> getAllByDisponible(Disponibilite disponible);

    Optional<Mécanicien> findBynumTelephone(String numTelephone);

}
