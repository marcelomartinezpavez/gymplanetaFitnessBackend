package com.gimnasio.planetaFitness.controller;

import com.gimnasio.planetaFitness.dto.ClientDto;
import com.gimnasio.planetaFitness.dto.EmpresaDto;
import com.gimnasio.planetaFitness.dto.PlanDto;
import com.gimnasio.planetaFitness.repository.EmpresaRepository;
import com.gimnasio.planetaFitness.service.ClientService;
import com.gimnasio.planetaFitness.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller  
@RequestMapping("client")
public class ClientController {

    @Autowired
    ClientService clienteService;

    @Autowired
    PlanService planService;

    @Autowired
    EmpresaRepository empresaRepository;

    @GetMapping(path = "/all", produces = "application/json")
    @CrossOrigin(origins = "*")
    public @ResponseBody
    ResponseEntity getAllCliente() {
        return clienteService.getAll();
    }

    @GetMapping(path = "/empresa/{idempresa}", produces = "application/json")
    @CrossOrigin(origins = "*")
    public @ResponseBody
    ResponseEntity getAllClientePorEmpresa(@PathVariable long idempresa) {
        return clienteService.getClientByCompany(idempresa);
    }

    @GetMapping(value = "/{rut}", produces = "application/json")
    @CrossOrigin(origins = "*")
    public @ResponseBody ResponseEntity getCliente(@PathVariable String rut) {
        return clienteService.getClientByRut(rut);
    }

    @PostMapping(path = "/insert",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ClientDto> create(@RequestBody com.gimnasio.planetaFitness.request.ClientRequest newCliente) {
        try {
            return clienteService.createClient(newCliente);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping(path = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ClientDto> update(@RequestBody com.gimnasio.planetaFitness.request.ClientRequest newCliente) {
        return clienteService.updateClient(newCliente);
    }

    @DeleteMapping(path = "/delete",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ClientDto> delete(@RequestBody com.gimnasio.planetaFitness.request.ClientRequest newCliente) {
        return clienteService.deleteClient(newCliente);
    }
}
