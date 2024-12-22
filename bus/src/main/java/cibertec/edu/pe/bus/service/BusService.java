package cibertec.edu.pe.bus.service;

import cibertec.edu.pe.bus.entities.Bus;
import cibertec.edu.pe.bus.repositories.IBusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {

    @Autowired
    IBusRepository busRepository;

    public List<Bus> obtenerBusesPorIdViaje(Long idViaje) {
        return busRepository.findByIdViaje(idViaje);
    }

    public List<Bus> getAllBus(){
        return busRepository.findAll();
    }

    public ResponseEntity<String> createBus(Bus bus){
        if (bus.getCapacidad() < 0) {
            throw new IllegalArgumentException("La capacidad no puede ser negativa.");
        }
        busRepository.save(bus);
        return new ResponseEntity<>("Bus creado con exito", HttpStatus.CREATED);
    }

    public Bus updateBus(Long idBus, Bus bus) {
        Bus existingBus = busRepository.findById(idBus).orElse(null);
        if (existingBus != null) {
            existingBus.setPlaca(bus.getPlaca());
            existingBus.setModelo(bus.getModelo());
            existingBus.setCapacidad(bus.getCapacidad());
            existingBus.setEmpresa(bus.getEmpresa());
            return busRepository.save(existingBus);
        }
        return null;
    }

    public void deleteBus(Long idBus) {
        busRepository.deleteById(idBus);
    }

}
