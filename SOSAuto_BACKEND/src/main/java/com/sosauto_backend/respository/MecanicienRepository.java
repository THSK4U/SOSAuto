package com.sosauto_backend.respository;


import com.sosauto_backend.model.Entity.Mecanicien;
import com.sosauto_backend.model.Enum.Disponibilite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MecanicienRepository extends JpaRepository<Mecanicien,Long> {

    List<Mecanicien> getAllByDisponible(Disponibilite disponible);

    Optional<Mecanicien> findBynumTelephone(String numTelephone);

}
