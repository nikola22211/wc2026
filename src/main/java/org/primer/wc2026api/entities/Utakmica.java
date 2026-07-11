package org.primer.wc2026api.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wc2026")
public class Utakmica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tim1")
    private String tim1;

    @Column(name = "tim2")
    private String tim2;

    @Column(name = "rez")
    private String rezultat;

    @Column(name = "faza")
    private String faza;

    @Column(name = "datum")
    private LocalDate datum;


}
