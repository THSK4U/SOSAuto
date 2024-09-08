package com.sosauto_backend.respository;

import com.sosauto_backend.model.Entity.Automobiliste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AutomobilisteRepository extends JpaRepository<Automobiliste,Long> {

    Optional<Automobiliste> findBynumTelephone(String numTelephone);
}
