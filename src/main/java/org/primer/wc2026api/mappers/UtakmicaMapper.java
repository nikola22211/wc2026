package org.primer.wc2026api.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.primer.wc2026api.entities.Utakmica;
import org.primer.wc2026api.entities.UtakmicaDto;

@Mapper(componentModel = "spring")
public interface UtakmicaMapper {

    @Mapping(target = "stadionId",source = "stadion.id")
    UtakmicaDto toDto(Utakmica utakmica);

}
