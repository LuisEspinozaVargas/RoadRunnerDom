package cibertec.edu.pe.ruta.service;

import cibertec.edu.pe.ruta.entities.Ruta;
import cibertec.edu.pe.ruta.repository.RutaRepository;
import cibertec.edu.pe.viaje.entities.Viaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutaService {

    @Autowired
    private RutaRepository rutaRepository;

    public List<Ruta> obtenerRutasPorIdViaje(Long idViaje) {
        return rutaRepository.findByIdViaje(idViaje);
    }

    public List<Ruta> listarRutas() {
        return rutaRepository.findAll();
    }

    public Ruta updateRuta(Long idRuta, Ruta ruta) {
        Ruta existingRuta = rutaRepository.findById(idRuta).orElse(null);
        if (existingRuta != null) {
            existingRuta.setDistancia(ruta.getDistancia());
            existingRuta.setDuracion(ruta.getDuracion());
            existingRuta.setIdViaje(ruta.getIdViaje());
            return rutaRepository.save(existingRuta);
        }
        return null;
    }

    public void eliminarRuta(Long idRuta) {
        rutaRepository.deleteById(idRuta);
    }

    public Ruta createRuta(Ruta ruta){
        return rutaRepository.save(ruta);
    }
}
