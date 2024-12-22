package cibertec.edu.pe.ruta.controller;

import cibertec.edu.pe.bus.entities.Bus;
import cibertec.edu.pe.bus.service.BusService;
import cibertec.edu.pe.ruta.entities.Ruta;
import cibertec.edu.pe.ruta.service.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ruta")
public class RutaController {

    @Autowired
    private RutaService rutaService;

    @GetMapping("/list")
    public List<Ruta> list() {
        return rutaService.listarRutas();
    }

    @GetMapping("/{idViaje}")
    public ResponseEntity<List<Ruta>> obtenerRutas(@PathVariable Long idViaje) {
        List<Ruta> rutas = rutaService.obtenerRutasPorIdViaje(idViaje);
        return rutas.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(rutas, HttpStatus.OK);
    }

    @PostMapping("/save")
    public Ruta createRuta(Ruta ruta){
        return rutaService.createRuta(ruta);
    }

    @PutMapping("/{idRuta}")
    public ResponseEntity<Ruta> updateRuta(@PathVariable Long idRuta, Ruta ruta){
        Ruta updatedRuta = rutaService.updateRuta(idRuta,ruta);
        return ResponseEntity.ok(updatedRuta);
    }

    @DeleteMapping("/{idRuta}")
    public void deleteRuta(@PathVariable Long idViaje){
        rutaService.eliminarRuta(idViaje);
    }
}
