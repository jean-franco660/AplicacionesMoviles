package pe.edu.upeu.milkminder.services;

import pe.edu.upeu.milkminder.dtos.GanadoDto;
import pe.edu.upeu.milkminder.models.Ganado;

import java.util.List;
import java.util.Map;

public interface GanadoService {
    Ganado save(GanadoDto.GanadoCrearDto entidad);
    List<Ganado> findAll();
    Map<String, Boolean> delete(Long id);

    List<Ganado> getGanadoById(Long id);

    Ganado update(GanadoDto.GanadoCrearDto entidad, Long id);
}
