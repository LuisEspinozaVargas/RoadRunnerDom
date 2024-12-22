package com.cibertec.edu.feign;

import com.cibertec.edu.model.Pago;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "pago", url = "http://localhost:8082")
public interface PagoClient {
    @GetMapping("/api/pago/{idPasaje}")
    List<Pago> obtenerPagos(@PathVariable Long idPasaje);
}
