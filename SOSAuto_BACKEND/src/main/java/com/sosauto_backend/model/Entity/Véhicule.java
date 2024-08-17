package com.sosauto_backend.model.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Véhicule {

    private int id;
    private String marque;
    private String modele;
    private int année;
    private String matricule;
    private String couleur;

    @ManyToOne



}
