package com.gimnasio.planetaFitness.controller;

import com.gimnasio.planetaFitness.dto.ClientDto;
import com.gimnasio.planetaFitness.dto.EmpresaDto;
import com.gimnasio.planetaFitness.dto.PaymentsDto;
import com.gimnasio.planetaFitness.dto.PlanDto;
import com.gimnasio.planetaFitness.repository.ClientRepository;
import com.gimnasio.planetaFitness.repository.EmpresaRepository;
import com.gimnasio.planetaFitness.repository.PaymentsRepository;
import com.gimnasio.planetaFitness.repository.PlanRepository;
import com.gimnasio.planetaFitness.request.PaymentRequest;
import com.gimnasio.planetaFitness.response.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

        return new ResponseEntity<>(paymentsDtoList, HttpStatus.OK);
    }

    @GetMapping(value = "/cliente/{rutCliente}", produces = "application/json")
    @CrossOrigin(origins = "*")
    public @ResponseBody
    ResponseEntity getPaymentByCliente(@PathVariable String rutCliente) {

        List<PaymentsDto> paymentsDtoList = paymentsRepository.findByRutCliente(rutCliente);

        //VehiculoResponse vehiculoResponse = new VehiculoResponse();
        //vehiculoResponse.setVehiculoDtoList(vehRespList);
        return new ResponseEntity<>(paymentsDtoList, HttpStatus.OK);

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

        paymentDto.setEmpresa(empresaDtoOptional.get());
        paymentDto.setDate(newPayment.getDate());
        paymentDto.setClient(clientDtoOptional.get());
        paymentDto.setTypeOfPayment(newPayment.getTypeOfPayment());
        paymentDto.setPlan(planDtoOptional.get());
        paymentDto.setExpiredAt(newPayment.getExpiredAt());
        paymentDto.setPrice(newPayment.getPrice());

        try {
            PaymentsDto paymentAgregado = paymentsRepository.save(paymentDto);

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
