package com.cibertec.edu.controller;

import com.cibertec.edu.service.RoadrunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/detalles")
public class RoadrunnerController {

    @Autowired
    private RoadrunnerService roadrunnerService;

    @GetMapping("/buses/{idViaje}")
    public ResponseEntity<Map<String, Object>> obtenerDetalles(@PathVariable Long idViaje) {
        Map<String, Object> response = roadrunnerService.obtenerDetallesViaje(idViaje);

        if (response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/rutas/{idViaje}")
    public ResponseEntity<Map<String, Object>> obtenerRutas(@PathVariable Long idViaje) {
        Map<String, Object> response = roadrunnerService.obtenerDetallesRutas(idViaje);

        if (response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/pagos/{idPasaje}")
    public ResponseEntity<Map<String, Object>> obtenerPagos(@PathVariable Long idPasaje) {
        Map<String, Object> response = roadrunnerService.obtenerDetallesPagos(idPasaje);

        if (response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
