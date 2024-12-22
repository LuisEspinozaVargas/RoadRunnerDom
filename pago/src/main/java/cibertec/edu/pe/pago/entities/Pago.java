package cibertec.edu.pe.pago.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "pago")
@NoArgsConstructor
@AllArgsConstructor
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    private Long idPasaje;
    private Double monto;
    private String metodoPago;
    private LocalDateTime fechaPago;
}
