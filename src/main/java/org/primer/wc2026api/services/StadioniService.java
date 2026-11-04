package org.primer.wc2026api.services;

import lombok.AllArgsConstructor;
import org.primer.wc2026api.entities.Stadion;
import org.primer.wc2026api.repositories.StadioniRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StadioniService {

    private final StadioniRepository stadioniRepository;

    public List<Stadion> prikaziSve(){

        return stadioniRepository.findAll();

    }


}
