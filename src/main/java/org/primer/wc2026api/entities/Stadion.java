package org.primer.wc2026api.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "stadioni_wc")
public class Stadion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "mesto")
    private String mesto;

    @Column(name = "kapacitet")
    private Integer kapacitet;

    @OneToMany(mappedBy = "stadion")
    @JsonIgnore
    private List<Utakmica> utakmice;

}
