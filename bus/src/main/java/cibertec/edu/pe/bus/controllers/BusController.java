package cibertec.edu.pe.bus.controllers;

import cibertec.edu.pe.bus.entities.Bus;
import cibertec.edu.pe.bus.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/bus")
@RestController
public class BusController {

    @Autowired
    BusService busService;

    @GetMapping("/{idViaje}")
    public ResponseEntity<List<Bus>> obtenerBuses(@PathVariable Long idViaje) {
        List<Bus> buses = busService.obtenerBusesPorIdViaje(idViaje);
        return buses.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(buses, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Bus> getAllBus(){
        return busService.getAllBus();
    }

    @PostMapping
    public ResponseEntity<String> saveBus(@RequestBody Bus bus){
        ResponseEntity<String> response = busService.createBus(bus);
        return response;
    }

    @PutMapping("/{idBus}")
    public ResponseEntity<Bus> updateBus(@PathVariable Long idBus, @RequestBody Bus bus) {
        Bus updatedBus = busService.updateBus(idBus, bus);
        return ResponseEntity.ok(updatedBus);
    }

    @DeleteMapping("/{idBus}")
    public void deleteBus(@PathVariable Long idBus) {
        busService.deleteBus(idBus);
    }

}
