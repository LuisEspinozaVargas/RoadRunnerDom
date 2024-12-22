package com.cibertec.edu.feign;

import com.cibertec.edu.model.Pasaje;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pasaje", url = "http://localhost:8083")
public interface PasajeClient {
    @GetMapping("/api/pasaje/{idPasaje}")
    Pasaje obtenerPasaje(@PathVariable Long idPasaje);


}
