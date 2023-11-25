package pe.edu.upeu.milkminder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.milkminder.models.Ganado;

public interface GanadoRepository extends JpaRepository<Ganado, Long> {
}
