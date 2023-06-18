package com.gimnasio.planetaFitness.service;

import com.gimnasio.planetaFitness.request.PlanRequest;
import com.gimnasio.planetaFitness.dto.PlanDto;

import org.springframework.http.ResponseEntity;

public interface PlanService {

    ResponseEntity getAllPlan();

    ResponseEntity getAllPlanEnabled();

    ResponseEntity getPlan(long id);

    ResponseEntity create(PlanRequest newPlan);

    ResponseEntity update(PlanRequest newProveedor);

    ResponseEntity delete(PlanDto newProveedor);
}
