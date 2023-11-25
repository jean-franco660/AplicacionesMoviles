package pe.edu.upeu.milkminder.services;

import pe.edu.upeu.milkminder.models.Leche;

import java.util.List;
import java.util.Map;

public interface LecheService {
    Leche save(Leche leche);

    List<Leche> findAll();
    Map<String, Boolean> delete(Long id);

    Leche getLecheById(Long id);

    Leche update(Leche entidad, Long id);
}
