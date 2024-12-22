package cibertec.edu.pe.pasaje.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "pasaje")
@NoArgsConstructor
@AllArgsConstructor
public class Pasaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPasaje;

    private int idViaje;
    private Integer asiento;
    private LocalDateTime fechaCompra;

}
