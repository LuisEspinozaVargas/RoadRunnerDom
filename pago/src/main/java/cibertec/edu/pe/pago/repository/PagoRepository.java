package cibertec.edu.pe.pago.repository;

import cibertec.edu.pe.pago.entities.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> findByIdPasaje(Long idPasaje);
}
