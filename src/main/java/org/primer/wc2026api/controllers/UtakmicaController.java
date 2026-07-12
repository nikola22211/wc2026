package org.primer.wc2026api.controllers;


import lombok.AllArgsConstructor;
import org.primer.wc2026api.entities.Utakmica;
import org.primer.wc2026api.entities.UtakmicaDto;
import org.primer.wc2026api.mappers.UtakmicaMapper;
import org.primer.wc2026api.repositories.UtakmicaRepository;
import org.primer.wc2026api.services.UtakmicaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/utakmice")
public class UtakmicaController {

    private final UtakmicaService utakmicaService;
    private final UtakmicaMapper utakmicaMapper;

    @GetMapping("/sve")
    public ResponseEntity<List<Utakmica>> prikaziSve(){

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(utakmicaService.prikaziSve());

    }

    @GetMapping("")
    public ResponseEntity<List<UtakmicaDto>> sveOdEkipe(@RequestParam(required = false) String ekipa){
        List<Utakmica> utakmice = utakmicaService.sveOdEkipe(ekipa);
        if(utakmice.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        List<UtakmicaDto> utakDto = utakmice.stream().map(utakmicaMapper::toDto).toList();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(utakDto);
    }

}
