package com.example.milkminder.Repository;

import com.example.milkminder.Models.Ganado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GanadoRespository extends JpaRepository<Ganado, Long> {
}
