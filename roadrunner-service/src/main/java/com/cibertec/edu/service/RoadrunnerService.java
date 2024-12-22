package com.cibertec.edu.service;

import com.cibertec.edu.feign.*;
import com.cibertec.edu.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoadrunnerService {

    @Autowired
    private ViajeClient viajeClient;

    @Autowired
    private BusClient busClient;

    @Autowired
    private RutaClient rutaClient;

    @Autowired
    private PagoClient pagoClient;

    @Autowired
    private PasajeClient pasajeClient;

    public Map<String, Object> obtenerDetallesViaje(Long idViaje) {
        Viaje viaje = viajeClient.obtenerViaje(idViaje);
        List<Bus> buses = busClient.obtenerBuses(idViaje);
        List<Ruta> rutas = rutaClient.obtenerRutas(idViaje);

        if (viaje == null || buses.isEmpty() || rutas.isEmpty()) {
            return null;
        }

        Map<String, Object> response = new HashMap<>();
        response.put("buses", buses);
        response.put("rutas", rutas);
        response.put("viaje", viaje);

        return response;
    }

    public Map<String, Object> obtenerDetallesRutas(Long idRuta) {
        Viaje viaje = viajeClient.obtenerViaje(idRuta);
        List<Ruta> rutas = rutaClient.obtenerRutas(idRuta);
        if (viaje == null || rutas.isEmpty()) {
            return null;
        }

        Map<String, Object> response = new HashMap<>();
        response.put("rutas", rutas);
        response.put("viaje", viaje);

        return response;
    }

    public Map<String, Object> obtenerDetallesPagos(Long idPago) {
        Pasaje pasaje = pasajeClient.obtenerPasaje(idPago);
        List<Pago> pagos = pagoClient.obtenerPagos(idPago);
        if (pasaje == null || pagos.isEmpty()) {
            return null;
        }

        Map<String, Object> response = new HashMap<>();
        response.put("pagos", pagos);
        response.put("pasaje", pasaje);

        return response;
    }

}
