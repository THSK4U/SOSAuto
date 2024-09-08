package com.sosauto_backend.model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sosauto_backend.model.Enum.Disponibilite;
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
public class Mécanicien extends Personne{
    private Double latitude;
    private Double longitude;
    private String proofOfProfessionUrl;
    @Enumerated(EnumType.STRING)
    private Disponibilite disponible;

    @OneToMany(mappedBy = "mécanicien",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<DemandeDepannage> demandeDepannage;

    @OneToMany(mappedBy = "mecanicien")
    @JsonIgnore
    private List<Participation> participation;
}
