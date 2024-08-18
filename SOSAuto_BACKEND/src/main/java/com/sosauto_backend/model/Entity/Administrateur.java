package com.sosauto_backend.model.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue(value = "ADMIN")
public class Administrateur extends Personne {

}
