package com.gimnasio.planetaFitness.controller;

import com.gimnasio.planetaFitness.dto.PlanDto;
import com.gimnasio.planetaFitness.request.PlanRequest;
import com.gimnasio.planetaFitness.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("plan")
public class PlanController {

    @Autowired
    PlanService planService;

    @GetMapping(path = "/all", produces = "application/json")
    @CrossOrigin(origins = "*")
    public @ResponseBody ResponseEntity getAllPlan() {
        return planService.getAllPlan();
    }

    @GetMapping(path = "/all/enable", produces = "application/json")
    @CrossOrigin(origins = "*")
    public @ResponseBody ResponseEntity getAllPlanEnabled() {
        return planService.getAllPlanEnabled();
    }


    @GetMapping(value = "/{id}", produces = "application/json")
    @CrossOrigin(origins = "*")
    public @ResponseBody
    ResponseEntity getPlan(@PathVariable long id) {

        return planService.getPlan(id);
    }

    @PostMapping(path = "/insert",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity create(@RequestBody PlanRequest newPlan) {
        newPlan.setEnabled(true);
        return planService.create(newPlan);
    }

    @PutMapping(path = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<PlanDto> update(@RequestBody PlanRequest newPlan) {
        return planService.update(newPlan);
    }

    @DeleteMapping(path = "/delete",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<PlanDto> delete(@RequestBody PlanDto newPlan) {
        return planService.delete(newPlan);
    }
}
