package com.sosauto_backend.respository;

import com.sosauto_backend.model.Entity.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long>{

    List<Participation> getAllByMecanicien_Personneid(Long personneId);

    @Transactional
    @Modifying
    @Query("Select p from Participation p Inner join DemandeDepannage dd on dd.demandeid = p.demande.demandeid where dd.automobiliste.personneid = :automobiliste_id")
    List<Participation> findParticipationsByautomobiliste_id(@Param("automobiliste_id") Long automobiliste_id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Participation p WHERE p.demande.demandeid = :demandeId AND p.mecanicien.personneid = :personneId")
    void deleteByDemande_DemandeidAndMecanicien_Personneid(Long demandeId, Long personneId);


    List<Participation> findAllByDemande_Demandeid(Long id);
}
