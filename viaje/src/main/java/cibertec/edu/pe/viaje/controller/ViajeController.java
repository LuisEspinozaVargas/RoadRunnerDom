package cibertec.edu.pe.viaje.controller;

import cibertec.edu.pe.viaje.entities.Viaje;
import cibertec.edu.pe.viaje.service.ViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viaje")
public class ViajeController {

    @Autowired
    private ViajeService viajeService;

    @GetMapping("/list")
    public List<Viaje> list() {
        return viajeService.getViajes();
    }

    @GetMapping("/{idViaje}")
    public ResponseEntity<Viaje> obtenerViaje(@PathVariable Long idViaje) {
        Viaje viaje = viajeService.obtenerViajePorIdViaje(idViaje);
        return viaje != null ? new ResponseEntity<>(viaje, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{idViaje}")
    public ResponseEntity<Viaje> updateViaje(@PathVariable Long idViaje, @RequestBody Viaje viaje) {
        Viaje updatedViaje = viajeService.updateViaje(idViaje, viaje);
        return ResponseEntity.ok(updatedViaje);
    }

    @DeleteMapping("/{idViaje}")
    public void eliminarViaje(@PathVariable Long idViaje) {
        viajeService.deleteViaje(idViaje);
    }

}
