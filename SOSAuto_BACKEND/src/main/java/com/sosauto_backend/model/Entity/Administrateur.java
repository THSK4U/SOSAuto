package com.sosauto_backend.model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Data
@Entity
@DiscriminatorValue(value = "ADMIN")
public class Administrateur extends Personne {

}
