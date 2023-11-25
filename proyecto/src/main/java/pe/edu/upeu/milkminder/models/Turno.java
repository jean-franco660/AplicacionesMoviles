package pe.edu.upeu.milkminder.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "turno")
public class Turno {

    public enum TurnoType{
        MORNING,
        AFTERNOON,
        NIGHT
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "turno", nullable = false)
    @Enumerated(EnumType.STRING)
    private TurnoType turno;
}
