package com.sosauto_backend.respository;

import com.sosauto_backend.model.entity.DemandeDepannage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeDepannageRepository extends JpaRepository<DemandeDepannage, Long> {

    //get by automobiliste_id
    List<DemandeDepannage> getALLByAutomobiliste_Personneid(Long personneId);
}
