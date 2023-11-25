package pe.edu.upeu.milkminder.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import pe.edu.upeu.milkminder.models.Leche;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.time.LocalDate;

public class GanadoController {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "arete", nullable = false)
    private String arete;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;

    @Column(name = "foto_url", nullable = false)
    private String foto_url;


    @JoinColumn(name = "leche_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Leche lecheid;
}
