package pe.edu.upeu.milkminder.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.edu.upeu.milkminder.dtos.GanadoDto;
import pe.edu.upeu.milkminder.models.Ganado;

@Mapper(componentModel = "spring")
public interface GanadoMapper {

    GanadoDto toGanadoDto(Ganado entidad);

    @Mapping(target = "lecheId", ignore = true)
    Ganado ganadoCrearDtoToGanado(GanadoDto.GanadoCrearDto entidadCrearDto);
}