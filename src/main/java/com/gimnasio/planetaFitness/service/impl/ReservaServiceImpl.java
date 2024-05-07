package com.gimnasio.planetaFitness.service.impl;

import com.gimnasio.planetaFitness.dto.ReservaDto;
import com.gimnasio.planetaFitness.repository.ClaseRepository;
import com.gimnasio.planetaFitness.repository.ReservaRepository;
import com.gimnasio.planetaFitness.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    ReservaRepository reservaRepository;

    public ResponseEntity getReservaByClient(String rut){
        return new ResponseEntity(reservaRepository.findByClient(rut),HttpStatus.OK);
    }

    public ResponseEntity createReserva(ReservaDto newReserva){
        return new ResponseEntity(reservaRepository.save(newReserva), HttpStatus.OK);
    }
}
