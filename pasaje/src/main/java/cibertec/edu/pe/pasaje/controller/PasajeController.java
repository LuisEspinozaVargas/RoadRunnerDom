package cibertec.edu.pe.pasaje.controller;

import cibertec.edu.pe.pasaje.entities.Pasaje;
import cibertec.edu.pe.pasaje.service.PasajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pasaje")
public class PasajeController {

    @Autowired
    private PasajeService pasajeService;

    @GetMapping("/list")
    public List<Pasaje> listarPasajes(){
        return pasajeService.listarPasajes();
    }


    @GetMapping("/{idPasaje}")
    public ResponseEntity<Pasaje> obtenerPasaje(@PathVariable Long idPasaje) {
        Pasaje pasaje = pasajeService.obtenerPasajePorIdPasaje(idPasaje);
        return pasaje != null ? new ResponseEntity<>(pasaje, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public Pasaje createPasaje(Pasaje pasaje){
        return pasajeService.createPasaje(pasaje);
    }

    @DeleteMapping("/{idPasaje}")
    public ResponseEntity<String> eliminarPasaje(@PathVariable Long idPasaje) {
        try {
            pasajeService.deletePasaje(idPasaje);
            return ResponseEntity.ok("Pasaje eliminado correctamente.");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pasaje no encontrado.");
        }
    }

    @PutMapping("/{idPasaje}")
    public ResponseEntity<Pasaje> updatePasaje(@PathVariable Long idPasaje, Pasaje pasaje) {
        Pasaje updatedPasaje = pasajeService.updatePasaje(idPasaje, pasaje);
        return ResponseEntity.ok(updatedPasaje);
    }
}
