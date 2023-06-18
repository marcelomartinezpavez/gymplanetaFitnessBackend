package com.gimnasio.planetaFitness.service.impl;

import com.gimnasio.planetaFitness.dto.ClientDto;
import com.gimnasio.planetaFitness.dto.EmpresaDto;
import com.gimnasio.planetaFitness.dto.PaymentsDto;
import com.gimnasio.planetaFitness.dto.PlanDto;
import com.gimnasio.planetaFitness.repository.ClientRepository;
import com.gimnasio.planetaFitness.repository.PaymentsRepository;
import com.gimnasio.planetaFitness.repository.PlanRepository;
import com.gimnasio.planetaFitness.request.PlanRequest;
import com.gimnasio.planetaFitness.service.PlanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    PlanRepository planRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    PaymentsRepository paymentsRepository;

    public ResponseEntity getAllPlan(){
        List<PlanDto> planDtoList = planRepository.findAll();

        List<PlanDto> planDtoListResp = new ArrayList<PlanDto>();
        for (int i = 0; i<planDtoList.size();i++){
            PlanDto plan = new PlanDto();
            PlanDto planResp = planDtoList.get(i);
            //plan.setClients(planResp.getClients());
            //plan.setPayments(planResp.getPayments());
            plan.setDescription(planResp.getDescription());
            plan.setEnabled(planResp.isEnabled());
            plan.setId(planResp.getId());
            plan.setName(planResp.getName());
            plan.setPeriod(planResp.getPeriod());
            plan.setPrice(planResp.getPrice());

            planDtoListResp.add(plan);
        }
        return new ResponseEntity(planDtoListResp, HttpStatus.OK);
    }

    public ResponseEntity getAllPlanEnabled(){
        List<PlanDto> planDtoList = planRepository.findAllHabilitado();

        List<PlanDto> planDtoListResp = new ArrayList<PlanDto>();
        for (int i = 0; i<planDtoList.size();i++){
            PlanDto plan = new PlanDto();
            PlanDto planResp = planDtoList.get(i);
            //plan.setClients(planResp.getClients());
            //plan.setPayments(planResp.getPayments());
            plan.setDescription(planResp.getDescription());
            plan.setEnabled(planResp.isEnabled());
            plan.setId(planResp.getId());
            plan.setName(planResp.getName());
            plan.setPeriod(planResp.getPeriod());
            plan.setPrice(planResp.getPrice());

            planDtoListResp.add(plan);
        }
        return new ResponseEntity(planDtoListResp, HttpStatus.OK);
    }

    public ResponseEntity getPlan(long id){
        Optional<PlanDto> planRespOptional = planRepository.findById(id);
        if(planRespOptional.isPresent()){
            PlanDto planResp = planRespOptional.get();
            PlanDto plan = new PlanDto();
            plan.setId(planResp.getId());
            plan.setName(planResp.getName());
            plan.setPeriod(planResp.getPeriod());
            plan.setPrice(planResp.getPrice());
            //plan.setClients(planResp.getClients());
            //plan.setPayments(planResp.getPayments());
            plan.setEnabled(planResp.isEnabled());
            plan.setDescription(planResp.getDescription());

            return new ResponseEntity(plan, HttpStatus.OK);

        }else{
            return new ResponseEntity("Plan no se encuentra",HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity create(PlanRequest newPlan){

        Optional<PlanDto> planDtoOptional = planRepository.findByNameAndHabilitado(newPlan.getName());
        if (planDtoOptional.isPresent()){
            if (!planDtoOptional.get().isEnabled()){
                return new ResponseEntity("Plan ya se encuentra registrado y esta deshabilitado",HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity("Plan ya existe",HttpStatus.BAD_REQUEST);
        }

        PlanDto plan = new PlanDto();

        plan.setEnabled(newPlan.isEnabled());
        plan.setName(newPlan.getName());
        //plan.setClients(clientDtoOptional.isPresent()? (Set<ClientDto>) clientDtoOptional.get() :null);
        plan.setPrice(newPlan.getPrice());
        plan.setPeriod(newPlan.getPeriod());
        //plan.setPayments(paymentsDtoOptional.isPresent()?paymentsDtoOptional.get():null);
        plan.setDescription(newPlan.getDescription());

        try {
            planRepository.save(plan);
        }catch (Exception e){
            return new ResponseEntity("Error interno al crear Plan", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(plan, HttpStatus.CREATED);
    }

    public ResponseEntity update(PlanRequest newPlan){
        PlanDto plan = new PlanDto();

        plan.setId(newPlan.getId());
        plan.setEnabled(newPlan.isEnabled());
        plan.setName(newPlan.getName());
        //plan.setClients(clientDtoOptional.isPresent()? (Set<ClientDto>) clientDtoOptional.get() :null);
        plan.setPrice(newPlan.getPrice());
        plan.setPeriod(newPlan.getPeriod());
        //plan.setPayments(paymentsDtoOptional.isPresent()?paymentsDtoOptional.get():null);
        plan.setDescription(newPlan.getDescription());


        planRepository.save(plan);

        return new ResponseEntity(plan, HttpStatus.CREATED);
    }

    public ResponseEntity delete(PlanDto newPlan){
        Optional<PlanDto> plan = planRepository.findById(newPlan.getId());
        if(plan.isPresent()){
            plan.get().setEnabled(false);
            planRepository.save(plan.get());
        }else{
            return new ResponseEntity("Error plan no existe.",HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(plan, HttpStatus.OK);

    }

}
