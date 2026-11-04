package org.primer.wc2026api.controllers;


import lombok.AllArgsConstructor;
import org.primer.wc2026api.entities.Stadion;
import org.primer.wc2026api.services.StadioniService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/stadioni")
public class StadioniController {

    private final StadioniService stadioniService;

    @GetMapping("sve")
    public ResponseEntity<List<Stadion>> prikaziSve(){

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(stadioniService.prikaziSve());

    }


}
