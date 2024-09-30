package com.sosauto_backend.model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue(value = "AUTOM")
public class Automobiliste extends Personne{

    @OneToMany(mappedBy = "automobiliste",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Vehicule> vehicules;

    @OneToMany(mappedBy = "automobiliste",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<DemandeDepannage> demandeDepannage;

}
