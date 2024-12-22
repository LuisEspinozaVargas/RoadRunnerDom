package cibertec.edu.pe.pago.service;

import cibertec.edu.pe.pago.entities.Pago;
import cibertec.edu.pe.pago.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> findAll() {
        return pagoRepository.findAll();
    }

    public List<Pago> obtenerPagosPorIdPasaje(Long idPasaje) {
        return pagoRepository.findByIdPasaje(idPasaje);
    }

    public Pago createPago(Pago pago){
        return pagoRepository.save(pago);
    }

    public String updatePago(Long idPago, Pago pago){
        Pago pagos = pagoRepository.findById(idPago).get();
        if(pagos != null){
            pagos.setMonto(pago.getMonto());
            pagos.setMetodoPago(pago.getMetodoPago());
            pagos.setFechaPago(pago.getFechaPago());

            pagoRepository.save(pagos);
            return "Pago actualizado com sucesso!";
        }
        else return "Pago no encontrado!";
    }

    public void eliminarPago(Long idPago){
        pagoRepository.deleteById(idPago);
    }


}
