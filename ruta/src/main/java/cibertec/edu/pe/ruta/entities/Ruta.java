package cibertec.edu.pe.ruta.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "ruta")
@NoArgsConstructor
@AllArgsConstructor
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRuta;
    private Double duracion;
    private Long idViaje;
    private Double distancia;

}
