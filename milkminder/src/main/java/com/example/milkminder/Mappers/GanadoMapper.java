package com.example.milkminder.Mappers;

import com.example.milkminder.Models.Ganado;
import com.example.milkminder.dto.GanadoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface GanadoMapper {

    GanadoDto toGanadoDto(Ganado endtidad);

    @Mapping(target = "lecheId", ignore = true)
    Ganado ganadoCrearDtoToGanado(GanadoDto.GanadoCrearDto entidadCrearDto);
}
