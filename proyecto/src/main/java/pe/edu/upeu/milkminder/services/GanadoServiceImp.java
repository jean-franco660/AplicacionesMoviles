package pe.edu.upeu.milkminder.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pe.edu.upeu.milkminder.dtos.GanadoDto;
import pe.edu.upeu.milkminder.exceptions.AppException;
import pe.edu.upeu.milkminder.exceptions.ResourceNotFoundException;
import pe.edu.upeu.milkminder.mappers.GanadoMapper;
import pe.edu.upeu.milkminder.models.Ganado;
import pe.edu.upeu.milkminder.repositories.GanadoRepository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Transactional
public class GanadoServiceImp implements GanadoService {
    @Autowired
    private GanadoRepository ganadoRepository;

    @Autowired
    private LecheService lecheService;

    private final GanadoMapper ganadoMapper;
    @Override
    public Ganado save(GanadoDto.GanadoCrearDto entidad) {
        Ganado varEnt=ganadoMapper.ganadoCrearDtoToGanado(entidad);
        varEnt.setLecheId(lecheService.getLecheById(entidad.lecheid()));

        try {
            return ganadoRepository.save(varEnt);
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Ganado> findAll() {
        try {
            return ganadoRepository.findAll();
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        Ganado entidadx = ganadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Materialesx not exist with id :" + id));
        ganadoRepository.delete(entidadx);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);

        return response;
    }

    @Override
    public List<Ganado> getGanadoById(Long id) {
        Ganado findEntidad = ganadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Materialesx not exist with id :" + id));
        return Collections.singletonList(findEntidad);
    }


    @Override
    public Ganado update(GanadoDto.GanadoCrearDto entidad, Long id) {
        Ganado entidadx = ganadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Periodo not exist with id :" + id));
        entidadx.setNombre(entidad.nombre());
        return ganadoRepository.save(entidadx);
    }
}