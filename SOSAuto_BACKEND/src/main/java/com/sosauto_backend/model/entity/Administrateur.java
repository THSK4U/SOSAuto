package com.sosauto_backend.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue(value = "ADMIN")
public class Administrateur extends Personne {

    @Column(unique = true)
    private String username;

}
