package com.sosauto_backend.model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long véhiculeid;
    private String marque;
    private String modele;
    private int année;
    private String matricule;
    private String couleur;

    @ManyToOne
    @JoinColumn(name = "automobillisteId")
    private Automobiliste automobiliste;



}
