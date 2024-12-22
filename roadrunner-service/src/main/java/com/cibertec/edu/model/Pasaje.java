package com.cibertec.edu.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Pasaje {
    private Long idPasaje;
    private int idViaje;
    private int idUsuario;
    private Integer asiento;
    private LocalDateTime fechaCompra;

    public Long getIdPasaje() {
        return idPasaje;
    }

    public void setIdPasaje(Long idPasaje) {
        this.idPasaje = idPasaje;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getAsiento() {
        return asiento;
    }

    public void setAsiento(Integer asiento) {
        this.asiento = asiento;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
