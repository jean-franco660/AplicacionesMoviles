package pe.edu.upeu.milkminder.dtos;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upeu.milkminder.models.Leche;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GanadoDto {
    Long id;
    String arete;
    String nombre;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate fecha;
    String foto_url;
    @JsonIgnoreProperties({"ganado"})
    Leche lecheId;

    public record GanadoCrearDto( Long id,String arete,String nombre,LocalDate fechanac,
                                  String foto_url,Long lecheid){}
}
