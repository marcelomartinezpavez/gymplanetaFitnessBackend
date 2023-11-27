package com.gimnasio.planetaFitness.service;

import org.springframework.http.ResponseEntity;

public interface ClientService {

    ResponseEntity getAll();

    ResponseEntity getClientByCompany(long idempresa);

    ResponseEntity getClientByRut(String rut);

    ResponseEntity getClientByName(String name);

    ResponseEntity getClienteByLikeRut(String rut);
    ResponseEntity createClient(com.gimnasio.planetaFitness.request.ClientRequest newCliente);

    ResponseEntity updateClient(com.gimnasio.planetaFitness.request.ClientRequest newCliente);

    ResponseEntity deleteClient(com.gimnasio.planetaFitness.request.ClientRequest newCliente);

}
