package com.sosauto_backend.model.entity;

import com.sosauto_backend.model.enums.StatutParticipation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "demande_id")
    private DemandeDepannage demande;

    @ManyToOne
    @JoinColumn(name = "mecanicien_id")
    private Mecanicien mecanicien;

    @Enumerated(EnumType.STRING)
    private StatutParticipation status;

}
