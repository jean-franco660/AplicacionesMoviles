package pe.edu.upeu.milkminder.repositories;

import pe.edu.upeu.milkminder.models.Leche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecheRepository extends JpaRepository<Leche, Long> {
}