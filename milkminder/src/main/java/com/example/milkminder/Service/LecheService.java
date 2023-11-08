package com.example.milkminder.Service;

import com.example.milkminder.Models.Leche;
import com.example.milkminder.dto.LecheDto;

import java.util.List;
import java.util.Map;

public interface LecheService {
    Leche save(LecheDto.LecheCrearDto entidad);

    Leche save(Leche leche);

    List<Leche> findAll();
    Map<String, Boolean> delete(Long id);

    Leche getLecheById(Long id);

    Leche update(Leche leche, Long id);
}
