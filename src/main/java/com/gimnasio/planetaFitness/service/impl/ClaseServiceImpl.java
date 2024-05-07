package com.gimnasio.planetaFitness.service.impl;

import com.gimnasio.planetaFitness.dto.ClaseDto;
import com.gimnasio.planetaFitness.dto.ClientDto;
import com.gimnasio.planetaFitness.repository.ClaseRepository;
import com.gimnasio.planetaFitness.repository.PaymentsRepository;
import com.gimnasio.planetaFitness.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseServiceImpl implements ClaseService {

    @Autowired
    ClaseRepository claseRepository;
    public ResponseEntity getClaseById(String id){
        Optional<ClaseDto> resp = claseRepository.findById(Long.valueOf(id));
        return new ResponseEntity(resp, HttpStatus.OK);

    }

    public ResponseEntity createClase(ClaseDto newClase){
        return new ResponseEntity(claseRepository.save(newClase),HttpStatus.OK);
    }

    public ResponseEntity updateClase(ClaseDto newClase){
        return new ResponseEntity(claseRepository.save(newClase), HttpStatus.OK);
    }

    public ResponseEntity deleteClase(ClaseDto newClase){
        claseRepository.delete(newClase);
        return new ResponseEntity(HttpStatus.OK);
    }
}
