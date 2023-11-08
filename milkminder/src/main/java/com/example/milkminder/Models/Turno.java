package com.example.milkminder.Models;

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
@Table(name = "Turno")
public class Turno {

    public enum Truno {//Insertar Manualmente en la tabla global_rol ambas opciones
        Truno_AM, Truno_PM
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Turno", nullable = false)
    @Enumerated(EnumType.STRING)
    private Truno turno;
}
