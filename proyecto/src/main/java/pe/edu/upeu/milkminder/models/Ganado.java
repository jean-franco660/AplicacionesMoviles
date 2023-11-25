package pe.edu.upeu.milkminder.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ganado")
public class Ganado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "arete", nullable = false)
    private String arete;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fechanac;

    @Column(name = "foto_url", nullable = false)
    private String foto_url;

    @JoinColumn(name = "leche_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Leche LecheId;
}
