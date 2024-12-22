package com.cibertec.edu.feign;

import com.cibertec.edu.model.Bus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "bus", url = "http://localhost:8081")
public interface BusClient {
    @GetMapping("/api/bus/{idViaje}")
    List<Bus> obtenerBuses(@PathVariable("idViaje") Long idViaje);
}
