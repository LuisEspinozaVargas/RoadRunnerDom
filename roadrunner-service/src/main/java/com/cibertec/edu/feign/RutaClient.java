package com.cibertec.edu.feign;

import com.cibertec.edu.model.Ruta;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ruta", url = "http://localhost:8084")
public interface RutaClient {
    @GetMapping("/api/ruta/{idViaje}")
    List<Ruta> obtenerRutas(@PathVariable Long idViaje);
}
