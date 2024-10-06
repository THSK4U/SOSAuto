package com.sosauto_backend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sosauto_backend.model.enums.Disponibilite;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue(value = "MECA")
public class Mecanicien extends Personne{
    private Double latitude;
    private Double longitude;
    private String proofOfProfessionUrl;
    @Enumerated(EnumType.STRING)
    private Disponibilite disponible;
    private Double notation;

    @OneToMany(mappedBy = "mecanicien",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<DemandeDepannage> demandedepannage;

    @OneToMany(mappedBy = "mecanicien", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Participation> participation;
}
