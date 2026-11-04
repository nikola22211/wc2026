package org.primer.wc2026api.entities;


import lombok.Data;

import java.time.LocalDate;

@Data
public class UtakmicaDto {

    private String tim1;
    private String tim2;
    private String rezultat;
    private String faza;
    private LocalDate datum;
    private Long stadionId;

}
