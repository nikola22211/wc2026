package org.primer.wc2026api.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.primer.wc2026api.entities.UpdateUtakmicaRequest;
import org.primer.wc2026api.entities.Utakmica;
import org.primer.wc2026api.entities.UtakmicaDto;

@Mapper(componentModel = "spring")
public interface UtakmicaMapper {

    /*target – polje u koje upisujemo vrednost.
     source – odakle uzimamo vrednost.*/
    @Mapping(target = "stadionId",source = "stadion.id")
    UtakmicaDto toDto(Utakmica utakmica);
    void update(UpdateUtakmicaRequest updateUtakmicaRequest, @MappingTarget Utakmica utakmica);

}
