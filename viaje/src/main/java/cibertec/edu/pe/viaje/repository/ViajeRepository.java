package cibertec.edu.pe.viaje.repository;

import cibertec.edu.pe.viaje.entities.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViajeRepository extends JpaRepository<Viaje, Long> {
}
