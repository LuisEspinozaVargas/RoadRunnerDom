package cibertec.edu.pe.bus.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "bus")
@NoArgsConstructor
@AllArgsConstructor
public class  Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBus;

    private String placa;
    private Long idViaje;
    private String modelo;
    private Integer capacidad;
    private String empresa;
}
