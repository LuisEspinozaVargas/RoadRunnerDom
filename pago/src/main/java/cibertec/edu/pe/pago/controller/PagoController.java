package cibertec.edu.pe.pago.controller;

import cibertec.edu.pe.pago.entities.Pago;
import cibertec.edu.pe.pago.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pago")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping("/list")
    public List<Pago> listaPagos(){
        return pagoService.findAll();
    }

    @GetMapping("/{idPasaje}")
    public ResponseEntity<List<Pago>> obtenerPagos(@PathVariable Long idPasaje) {
        List<Pago> pagos = pagoService.obtenerPagosPorIdPasaje(idPasaje);
        return pagos.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(pagos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> savePago(@RequestBody Pago pago){
        pagoService.createPago(pago);
        return new ResponseEntity<>("Pago creado con exito", HttpStatus.CREATED);
    }

    @PutMapping("/{idPago}")
    public void updatePago(@PathVariable Long idPago, @RequestBody Pago pago){
        pagoService.updatePago(idPago, pago);
    }

    @DeleteMapping("/{idPago}")
    public void deletePago(@PathVariable Long idPago){
        pagoService.eliminarPago(idPago);
    }

}
