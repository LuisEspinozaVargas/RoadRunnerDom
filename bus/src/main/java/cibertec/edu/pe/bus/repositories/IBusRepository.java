package cibertec.edu.pe.bus.repositories;

import cibertec.edu.pe.bus.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBusRepository extends JpaRepository<Bus, Long> {
    List<Bus> findByIdViaje(Long idViaje);
}
