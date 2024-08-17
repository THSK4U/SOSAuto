package com.sosauto_backend.model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue(value = "AUTOM")
public class Automobiliste extends Personne{

    @OneToMany(mappedBy = "Automobiliste",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Véhicule> véhicules;
}
