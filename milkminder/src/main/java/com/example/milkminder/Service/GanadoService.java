package com.example.milkminder.Service;

import com.example.milkminder.Models.Ganado;
import com.example.milkminder.dto.GanadoDto;

import java.util.List;
import java.util.Map;

public interface GanadoService {
    Ganado save(GanadoDto.GanadoCrearDto entidad);
    List<Ganado> findAll();
    Map<String, Boolean> delete(Long id);

    List<Ganado> getGanadoById(Long id);

    Ganado update(GanadoDto.GanadoCrearDto entidad, Long id);
}
