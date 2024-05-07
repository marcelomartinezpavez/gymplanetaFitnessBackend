package com.gimnasio.planetaFitness.service;

import com.gimnasio.planetaFitness.dto.ClaseDto;
import com.gimnasio.planetaFitness.dto.ReservaDto;
import org.springframework.http.ResponseEntity;

public interface ReservaService {

    ResponseEntity getReservaByClient(String rut);

    ResponseEntity createReserva(ReservaDto newReserva);
}
