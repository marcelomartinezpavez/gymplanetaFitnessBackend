package com.gimnasio.planetaFitness.service;

import com.gimnasio.planetaFitness.dto.ClaseDto;
import org.springframework.http.ResponseEntity;

public interface ClaseService {

    ResponseEntity getClaseById(String id);

    ResponseEntity createClase(ClaseDto newClase);

    ResponseEntity updateClase(ClaseDto newClase);

    ResponseEntity deleteClase(ClaseDto newClase);

}
