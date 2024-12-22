package cibertec.edu.pe.pasaje.repository;

import cibertec.edu.pe.pasaje.entities.Pasaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PasajeRepository extends JpaRepository<Pasaje, Long> {
}
