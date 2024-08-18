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
@DiscriminatorValue(value = "MECA")
public class Mécanicien extends Personne{

    @OneToMany(mappedBy = "mécanicien",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<DemandeDepannage> demandeDepannage;
}
