package com.gimnasio.planetaFitness.controller;

import com.gimnasio.planetaFitness.dto.ClaseDto;
import com.gimnasio.planetaFitness.dto.ClientDto;
import com.gimnasio.planetaFitness.service.ClaseService;
import com.gimnasio.planetaFitness.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("clase")
public class ClaseController {
    @Autowired
    ClaseService claseService;

    @GetMapping(value = "/id/{id}", produces = "application/json")
    @CrossOrigin(origins = "*")
    public @ResponseBody ResponseEntity getClaseById(@PathVariable String id) {
        return claseService.getClaseById(id);
    }
    @PostMapping(path = "/insert",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ClaseDto> create(@RequestBody ClaseDto newClase) {
        try {
            return claseService.createClase(newClase);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping(path = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ClaseDto> update(@RequestBody ClaseDto newClase) {
        return claseService.updateClase(newClase);
    }

    @DeleteMapping(path = "/delete",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ClaseDto> delete(@RequestBody ClaseDto newClase) {
        return claseService.deleteClase(newClase);
    }

}
