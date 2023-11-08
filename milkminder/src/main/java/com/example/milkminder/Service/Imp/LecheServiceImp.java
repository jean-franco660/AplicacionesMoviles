package com.example.milkminder.Service.Imp;

import com.example.milkminder.Exceptions.AppException;
import com.example.milkminder.Exceptions.ResourceNotFoundException;
import com.example.milkminder.Models.Leche;
import com.example.milkminder.Repository.LecheRepository;
import com.example.milkminder.Service.LecheService;
import com.example.milkminder.dto.LecheDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Transactional
public class LecheServiceImp implements LecheService {
    @Autowired
    private LecheRepository lecheRepository;

    @Override
    public Leche save(LecheDto.LecheCrearDto entidad) {
        return null;
    }

    @Override
    public Leche save(Leche leche) {

        try {
            return lecheRepository.save(leche);
        } catch (Exception e) {
            throw new AppException("Error-"+e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Leche> findAll() {
        try {
            return lecheRepository.findAll();
        } catch (Exception e) {
            throw new AppException("Error-"+e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        Leche leche = lecheRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Actividad not exist with id :" + id));

        lecheRepository.delete(leche);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);

        return response;
    }

    @Override
    public Leche getLecheById(Long id) {
        Leche findLeche = lecheRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Activiad not exist with id :" + id));
        return findLeche;
    }
    @Override
    public Leche update(Leche leche, Long id) {
        leche = lecheRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Periodo not exist with id :" + id));
        leche.setCantidadLT(leche.getCantidadLT());
        return lecheRepository.save(leche);
    }
}
