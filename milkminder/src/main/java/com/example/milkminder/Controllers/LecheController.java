package com.example.milkminder.Controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "leche")
@RequestMapping("/ganado/leche")
public class LecheController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;

    @Column(name = "CantidadLT", nullable = false)
    private Double CantidadLT;

    @Column(name = "foto_url", nullable = false)
    private String foto_url;
    @Column(name = "foto_url", nullable = false)
    private String foto_url;
}
