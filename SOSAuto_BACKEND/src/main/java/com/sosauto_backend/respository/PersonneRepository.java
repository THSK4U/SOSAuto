package com.sosauto_backend.respository;

import com.sosauto_backend.model.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {

    //find by numer de telephone
    Optional<Personne> findBynumTelephone(String numTelephone);
}
