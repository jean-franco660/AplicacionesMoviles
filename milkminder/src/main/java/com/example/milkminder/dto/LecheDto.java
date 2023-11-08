package com.example.milkminder.dto;

import com.example.milkminder.Models.Turno;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LecheDto {
    Long id;
    LocalDate fecha;
    Double CantidadLT;
    String foto_url;
    @JsonIgnoreProperties({"Leche"})
    Turno turnoId;

    public record LecheCrearDto(Long id,LocalDate fecha,String foto_url,
                                  Long ganadoId){}
}
