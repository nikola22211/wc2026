package org.primer.wc2026api.services;

import lombok.AllArgsConstructor;
import org.primer.wc2026api.entities.Utakmica;
import org.primer.wc2026api.repositories.UtakmicaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@AllArgsConstructor
public class UtakmicaService {

    private final UtakmicaRepository utakmicaRepository;

    public List<Utakmica> prikaziSve(){

        return utakmicaRepository.findAll();

    }






}
