package com.sosauto_backend.model.Entity;

import com.sosauto_backend.model.Enum.EtatPanne;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DemandeDepannage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int panneid;
    @Column(updatable = false)
    private LocalDateTime dateTime;
    private Double latitude;
    private Double longitude;
    @Enumerated(EnumType.STRING)
    private EtatPanne etat;

    @PrePersist
    protected void onCreate() {
        dateTime = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "automobiliste_id")
    private Automobiliste automobiliste;

    @ManyToOne
    @JoinColumn(name = "mécanicien_id")
    private Mécanicien mécanicien;

    @ManyToOne
    @JoinColumn(name = "panne_id")
    private Panne panne;
}
