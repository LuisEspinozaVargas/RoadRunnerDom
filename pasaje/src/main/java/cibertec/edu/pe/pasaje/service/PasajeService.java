package cibertec.edu.pe.pasaje.service;

import cibertec.edu.pe.pasaje.entities.Pasaje;
import cibertec.edu.pe.pasaje.repository.PasajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasajeService {

    @Autowired
    private PasajeRepository pasajeRepository;

    public List<Pasaje> listarPasajes(){
        return pasajeRepository.findAll();
    }

    public Pasaje obtenerPasajePorIdPasaje(Long idPasaje){
        Optional<Pasaje> pasaje = pasajeRepository.findById(idPasaje);
        return pasaje.orElse(null);
    }

    public void deletePasaje(Long idPasaje){
        pasajeRepository.deleteById(idPasaje);
    }

    public Pasaje updatePasaje(Long idPasaje, Pasaje pasaje){
        Pasaje existingPasaje = pasajeRepository.findById(idPasaje).orElse(null);
        if(existingPasaje != null){
            existingPasaje.setAsiento(pasaje.getAsiento());
            existingPasaje.setFechaCompra(pasaje.getFechaCompra());
            existingPasaje.setIdViaje(pasaje.getIdViaje());
            return pasajeRepository.save(existingPasaje);
        }
        return null;
    }

    public Pasaje createPasaje(Pasaje pasaje){
        return pasajeRepository.save(pasaje);
    }
}
