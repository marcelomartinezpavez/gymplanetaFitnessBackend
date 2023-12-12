package com.gimnasio.planetaFitness.controller;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gimnasio.planetaFitness.dto.ClientDto;
import com.gimnasio.planetaFitness.dto.EmpresaDto;
import com.gimnasio.planetaFitness.dto.PaymentsDto;
import com.gimnasio.planetaFitness.dto.PlanDto;
import com.gimnasio.planetaFitness.repository.ClientRepository;
import com.gimnasio.planetaFitness.repository.EmpresaRepository;
import com.gimnasio.planetaFitness.repository.PaymentsRepository;
import com.gimnasio.planetaFitness.repository.PlanRepository;
import com.gimnasio.planetaFitness.request.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Controller
@RequestMapping("payment")
public class PaymentsController {

    @Autowired
    PaymentsRepository paymentsRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    PlanRepository planRepository;

    @GetMapping(path = "/all", produces = "application/json")
    @CrossOrigin(origins = "*")
    public @ResponseBody
    ResponseEntity getAllPayments() {
        System.out.println("getAll Payment");

        List<PaymentsDto> paymentsDtoList = paymentsRepository.findAll();
        List <PaymentsDto> resp = new ArrayList<>();

        for(PaymentsDto payment: paymentsDtoList){
            PaymentsDto paymentsDto = new PaymentsDto();
            ClientDto clientDto = new ClientDto();
            clientDto.setRut(payment.getClient().getRut());
            clientDto.setAddress(payment.getClient().getAddress());
            clientDto.setComuna(payment.getClient().getComuna());
            clientDto.setCity(payment.getClient().getCity());
            clientDto.setAuxiliarPhone(payment.getClient().getAuxiliarPhone());
            clientDto.setBirthDate(payment.getClient().getBirthDate());
            clientDto.setEmail(payment.getClient().getEmail());
            clientDto.setEnabled(payment.getClient().isEnabled());
            clientDto.setExpiredAt(payment.getClient().getExpiredAt());
            clientDto.setName(payment.getClient().getName());
            clientDto.setPhone(payment.getClient().getPhone());

            paymentsDto.setId(payment.getId());
            paymentsDto.setDate(payment.getDate());
            paymentsDto.setExpiredAt(payment.getExpiredAt());
            paymentsDto.setPrice(payment.getPrice());
            paymentsDto.setTypeOfPayment(payment.getTypeOfPayment());
            paymentsDto.setClient(clientDto);
            paymentsDto.setPlan(payment.getPlan());
            paymentsDto.setEmpresa(payment.getEmpresa());
            resp.add(paymentsDto);
        }
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value = "/cliente/{rutCliente}", produces = "application/json")
    @CrossOrigin(origins = "*")
    public @ResponseBody
    ResponseEntity getPaymentByCliente(@PathVariable String rutCliente) {

        List<PaymentsDto> paymentsDtoList = paymentsRepository.findByRutCliente(rutCliente);

        List <PaymentsDto> resp = new ArrayList<>();

        for(PaymentsDto payment: paymentsDtoList){
            PaymentsDto paymentsDto = new PaymentsDto();
            ClientDto clientDto = new ClientDto();
            clientDto.setRut(payment.getClient().getRut());
            clientDto.setAddress(payment.getClient().getAddress());
            clientDto.setComuna(payment.getClient().getComuna());
            clientDto.setCity(payment.getClient().getCity());
            clientDto.setAuxiliarPhone(payment.getClient().getAuxiliarPhone());
            clientDto.setBirthDate(payment.getClient().getBirthDate());
            clientDto.setEmail(payment.getClient().getEmail());
            clientDto.setEnabled(payment.getClient().isEnabled());
            clientDto.setExpiredAt(payment.getClient().getExpiredAt());
            clientDto.setName(payment.getClient().getName());
            clientDto.setPhone(payment.getClient().getPhone());

            paymentsDto.setId(payment.getId());
            paymentsDto.setDate(payment.getDate());
            paymentsDto.setExpiredAt(payment.getExpiredAt());
            paymentsDto.setPrice(payment.getPrice());
            paymentsDto.setTypeOfPayment(payment.getTypeOfPayment());
            paymentsDto.setClient(clientDto);
            paymentsDto.setPlan(payment.getPlan());
            paymentsDto.setEmpresa(payment.getEmpresa());
            resp.add(paymentsDto);
        }
        return new ResponseEntity<>(resp, HttpStatus.OK);

    }

    @PostMapping(path = "/insert",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity create(@RequestBody PaymentRequest newPayment) {

        PaymentsDto paymentDto = new PaymentsDto();

        Optional<EmpresaDto> empresaDtoOptional = empresaRepository.findById(newPayment.getIdEmpresa());
        if (!empresaDtoOptional.isPresent()){
            return new ResponseEntity("Empresa no se encuentra registrada",HttpStatus.BAD_REQUEST);
        }

        Optional<ClientDto> clientDtoOptional = clientRepository.findByRutAndHabilitado(newPayment.getRutClient());
        if (!clientDtoOptional.isPresent()){
            return new ResponseEntity("Cliente no se encuentra registrado",HttpStatus.BAD_REQUEST);
        }

        Optional<PlanDto> planDtoOptional = planRepository.findById(newPayment.getIdPlan());
        if (!planDtoOptional.isPresent()){
            return new ResponseEntity("Plan no se encuentra registrado",HttpStatus.BAD_REQUEST);
        }

        if(newPayment.getPrice()%planDtoOptional.get().getPrice() != 0){
            return new ResponseEntity<>("Valor de plan no concuerda con el pago",HttpStatus.CONFLICT);
        }

        ClientDto clientDto = new ClientDto();
        clientDto.setRut(clientDtoOptional.get().getRut());
        clientDto.setAddress(clientDtoOptional.get().getAddress());
        clientDto.setComuna(clientDtoOptional.get().getComuna());
        clientDto.setCity(clientDtoOptional.get().getCity());
        clientDto.setAuxiliarPhone(clientDtoOptional.get().getAuxiliarPhone());
        clientDto.setBirthDate(clientDtoOptional.get().getBirthDate());
        clientDto.setEmail(clientDtoOptional.get().getEmail());
        clientDto.setEnabled(clientDtoOptional.get().isEnabled());
        clientDto.setExpiredAt(clientDtoOptional.get().getExpiredAt());
        clientDto.setName(clientDtoOptional.get().getName());
        clientDto.setPhone(clientDtoOptional.get().getPhone());

        clientDto.setPlan(planDtoOptional.get());

        clientDto.setEmpresa(empresaDtoOptional.get());

        paymentDto.setClient(clientDto);

        paymentDto.setEmpresa(empresaDtoOptional.get());
        paymentDto.setDate(newPayment.getDate());

        paymentDto.setClient(clientDtoOptional.get());
        paymentDto.setTypeOfPayment(newPayment.getTypeOfPayment());
        paymentDto.setPlan(planDtoOptional.get());
        paymentDto.setExpiredAt(newPayment.getExpiredAt());
        paymentDto.setPrice(newPayment.getPrice());

        try {
            PaymentsDto paymentAgregado = paymentsRepository.save(paymentDto);
            //ClientDto newClientDto = clientDtoOptional.get();
            //clientDto.setPayment(paymentAgregado);
            clientDto.setExpiredAt(paymentDto.getExpiredAt());
            clientRepository.save(clientDto);
            //return new ResponseEntity(paymentDto, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity("Ocurrio un error interno",HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return new ResponseEntity(paymentDto, HttpStatus.CREATED);

    }
/*
    @PutMapping(path = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity update(@RequestBody PaymentRequest newPayment) {
        try {
            PaymentsDto paymentDto = new PaymentsDto();

            Optional<PaymentsDto> paymentsDtoOptional = paymentsRepository.findById(newPayment.getId());
            if(!paymentsDtoOptional.isPresent()){
                return new ResponseEntity("Ocurrio un error interno",HttpStatus.INTERNAL_SERVER_ERROR);
            }
            try {
                PaymentsDto paymentAgregado = paymentsRepository.save(paymentDto);

            }catch (Exception e){
                return new ResponseEntity("Ocurrio un error interno",HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity(paymentDto, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity("Ocurrio un error interno",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
*/

}
