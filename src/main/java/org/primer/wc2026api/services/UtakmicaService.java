package org.primer.wc2026api.services;

import lombok.AllArgsConstructor;
import org.primer.wc2026api.entities.UpdateUtakmicaRequest;
import org.primer.wc2026api.entities.Utakmica;
import org.primer.wc2026api.entities.UtakmicaDto;
import org.primer.wc2026api.mappers.UtakmicaMapper;
import org.primer.wc2026api.repositories.UtakmicaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UtakmicaService {

    private final UtakmicaRepository utakmicaRepository;
    private final UtakmicaMapper utakmicaMapper;

    public List<Utakmica> prikaziSve(){

        return utakmicaRepository.findAll();

    }

    public List<Utakmica> sveOdEkipe(String ekipa){
        List<Utakmica> utakmice = utakmicaRepository.findAll();
        List<Utakmica> ekipaUtakmice = new ArrayList<>();

        for(Utakmica u : utakmice){
            if(u.getTim1().equals(ekipa) || u.getTim2().equals(ekipa)){
                ekipaUtakmice.add(u);
            }
        }
        return ekipaUtakmice;
    }

    public List<UtakmicaDto> sveNaStadionu(Long stadionId){
        return utakmicaRepository.nadjiSveNaStadionu(stadionId).stream().map(utakmicaMapper::toDto).toList();
    }

    public List<UtakmicaDto> odredjenTip(Character c) {
        List<Utakmica> utakmice = utakmicaRepository.findAll();
        List<Utakmica> nadjene = new ArrayList<>();
        for (Utakmica u : utakmice) {
            if (u.getRezultat().charAt(0) > u.getRezultat().charAt(2) && c == '1') {
                nadjene.add(u);
            } else if (u.getRezultat().charAt(0) < u.getRezultat().charAt(2) && c == '2') {
                nadjene.add(u);
            } else if (u.getRezultat().charAt(0) == u.getRezultat().charAt(2) && (c == 'x' || c == 'X')) {
                nadjene.add(u);
            }
        }
        return nadjene.stream().map(utakmicaMapper::toDto).toList();
    }


    public ResponseEntity<UtakmicaDto> updateUtakmica(Long id,UpdateUtakmicaRequest request){
        var utakmica = utakmicaRepository.findById(id).orElse(null);
        if(utakmica == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        System.out.println(request.getTim1());
        System.out.println(request.getTim2());
        System.out.println(request.getRezultat());

        utakmicaMapper.update(request,utakmica);
        utakmicaRepository.save(utakmica);

        return ResponseEntity.status(HttpStatus.OK).body(utakmicaMapper.toDto(utakmica));

    }



}
