package cibertec.edu.pe.ruta.repository;

import cibertec.edu.pe.ruta.entities.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RutaRepository extends JpaRepository<Ruta, Long> {
    List<Ruta> findByIdViaje(Long idRuta);
}
