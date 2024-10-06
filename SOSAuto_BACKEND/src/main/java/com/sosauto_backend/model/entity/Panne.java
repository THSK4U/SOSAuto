package com.sosauto_backend.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Panne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long panneid;

    private String nom;
    private String description;

    @OneToMany(mappedBy = "panne",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<DemandeDepannage> ticketSupports;
}
