package cibertec.edu.pe.viaje.service;

import cibertec.edu.pe.bus.entities.Bus;
import cibertec.edu.pe.viaje.entities.Viaje;
import cibertec.edu.pe.viaje.repository.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViajeService {

    @Autowired
    private ViajeRepository viajeRepository;

    public List<Viaje> getViajes(){
        return viajeRepository.findAll();
    }

    public Viaje obtenerViajePorIdViaje(Long idViaje) {
        Optional<Viaje> viaje = viajeRepository.findById(idViaje);
        return viaje.orElse(null);
    }

    public Viaje updateViaje(Long idViaje, Viaje viaje) {
        Viaje existingViaje = viajeRepository.findById(idViaje).orElse(null);
        if (existingViaje != null) {
            existingViaje.setDestino(viaje.getDestino());
            existingViaje.setOrigen(viaje.getOrigen());
            existingViaje.setPrecio(viaje.getPrecio());
            existingViaje.setFechaLlegada(viaje.getFechaLlegada());
            existingViaje.setFechaSalida(viaje.getFechaSalida());
            return viajeRepository.save(existingViaje);
        }
        return null;
    }

    public void deleteViaje(Long idViaje) {
        viajeRepository.deleteById(idViaje);
    }
}
