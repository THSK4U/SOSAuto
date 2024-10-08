package com.sosauto_backend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sosauto_backend.model.enums.EtatPanne;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DemandeDepannage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long demandeid;
    @Column(updatable = false)
    private LocalDateTime dateTime;
    private Double latitude;
    private Double longitude;
    private String description;
    @Enumerated(EnumType.STRING)
    private EtatPanne etat;

    @PrePersist
    protected void onCreate() {
        dateTime = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "automobiliste_id",nullable = true)
    private Automobiliste automobiliste;

    @ManyToOne
    @JoinColumn(name = "mecanicien_id",nullable = true)
    private Mecanicien mecanicien;

    @ManyToOne
    @JoinColumn(name = "panne_id",nullable = true)
    private Panne panne;

    @OneToMany(mappedBy = "demande", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Participation> participation;
}
