package com.sosauto_backend.respository;

import com.sosauto_backend.model.Entity.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long>{

    List<Participation> getAllByMecanicien_Personneid(Long personneId);


}
