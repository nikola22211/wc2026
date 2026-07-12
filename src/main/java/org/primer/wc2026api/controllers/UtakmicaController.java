package org.primer.wc2026api.controllers;


import lombok.AllArgsConstructor;
import org.primer.wc2026api.entities.Utakmica;
import org.primer.wc2026api.repositories.UtakmicaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/utakmice")
public class UtakmicaController {

    private final UtakmicaRepository utakmicaRepository;

    @GetMapping("")
    public ResponseEntity<List<Utakmica>> prikaziSve(){

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(utakmicaRepository.findAll());

    }





}
