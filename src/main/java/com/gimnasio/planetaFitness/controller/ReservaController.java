package com.gimnasio.planetaFitness.controller;

import com.gimnasio.planetaFitness.dto.ClaseDto;
import com.gimnasio.planetaFitness.dto.ReservaDto;
import com.gimnasio.planetaFitness.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("reserva")
public class ReservaController {
    @Autowired
    ReservaService reservaService;

    @GetMapping(value = "/rut/{rut}", produces = "application/json")
    @CrossOrigin(origins = "*")
    public @ResponseBody ResponseEntity getReservaByRut(@PathVariable String rut) {
        return reservaService.getReservaByClient(rut);
    }
    @PostMapping(path = "/insert",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ReservaDto> create(@RequestBody ReservaDto newReserva) {
        try {
            return reservaService.createReserva(newReserva);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
