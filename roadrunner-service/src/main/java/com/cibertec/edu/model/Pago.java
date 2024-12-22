package com.cibertec.edu.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Pago {
    private Long idPago;
    private Long idUsuario;
    private Double monto;
    private String metodoPago;
    private LocalDateTime fechaPago;

}
