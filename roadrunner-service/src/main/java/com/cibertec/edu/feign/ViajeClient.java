package com.cibertec.edu.feign;

import com.cibertec.edu.model.Viaje;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viaje", url = "http://localhost:8086")
public interface ViajeClient {
    @GetMapping("/api/viaje/{idViaje}")
    Viaje obtenerViaje(@PathVariable Long idViaje);
}
