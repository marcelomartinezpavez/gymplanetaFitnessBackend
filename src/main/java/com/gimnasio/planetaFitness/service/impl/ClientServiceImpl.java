package com.gimnasio.planetaFitness.service.impl;

import com.gimnasio.planetaFitness.dto.ClientDto;
import com.gimnasio.planetaFitness.dto.EmpresaDto;
import com.gimnasio.planetaFitness.dto.PaymentsDto;
import com.gimnasio.planetaFitness.dto.PlanDto;
import com.gimnasio.planetaFitness.repository.ClientRepository;
import com.gimnasio.planetaFitness.repository.EmpresaRepository;
import com.gimnasio.planetaFitness.repository.PaymentsRepository;
import com.gimnasio.planetaFitness.repository.PlanRepository;
import com.gimnasio.planetaFitness.response.ClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Service
public class ClientServiceImpl implements com.gimnasio.planetaFitness.service.ClientService {

    @Autowired
    ClientRepository clienteRepository;

    @Autowired
    PlanRepository planRepository;

    @Autowired
    PaymentsRepository paymentRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    public ResponseEntity getAll(){
        System.out.println("getAll");
        List<ClientDto> resp = clienteRepository.findAllHabilitado();
        List<ClientDto> clienteDtoList = new ArrayList<ClientDto>();
        for (int i = 0; i<resp.size();i++){
            ClientDto cliente = new ClientDto();
            EmpresaDto empresaDto = new EmpresaDto();

            ClientDto clienteResp = resp.get(i);

            empresaDto.setId(clienteResp.getEmpresa().getId());
            empresaDto.setNombre(clienteResp.getEmpresa().getNombre());
            empresaDto.setRut(clienteResp.getEmpresa().getRut());
            empresaDto.setDireccion(clienteResp.getEmpresa().getDireccion());

            cliente.setRut(clienteResp.getRut());
            cliente.setAddress(clienteResp.getAddress());
            cliente.setComuna(clienteResp.getComuna());
            cliente.setCity(clienteResp.getCity());
            cliente.setComuna(clienteResp.getComuna());
            cliente.setAuxiliarPhone(clienteResp.getAuxiliarPhone());
            cliente.setEmail(clienteResp.getEmail());
            cliente.setBirthDate(clienteResp.getBirthDate());
            cliente.setRut(clienteResp.getRut());
            cliente.setEmail(clienteResp.getEmail());
            cliente.setEnabled(clienteResp.isEnabled());
            cliente.setExpiredAt(clienteResp.getExpiredAt());
            cliente.setName(clienteResp.getName());
            cliente.setPhone(clienteResp.getPhone());

            List<PaymentsDto> paymentsDtoList = paymentRepository.findByRutCliente(clienteResp.getRut());

            if(!paymentsDtoList.isEmpty()){
                cliente.setPayment(paymentsDtoList);
            }

            if(clienteResp.getPlan() != null){
                PlanDto planDto = new PlanDto();
                planDto.setId(clienteResp.getPlan().getId());
                planDto.setDescription(clienteResp.getPlan().getDescription());
                planDto.setEnabled(clienteResp.getPlan().isEnabled());
                planDto.setName(clienteResp.getPlan().getName());
                planDto.setPeriod(clienteResp.getPlan().getPeriod());
                planDto.setPrice(clienteResp.getPlan().getPrice());

                //cliente.setPlan(clienteResp.getPlan());
                cliente.setPlan(planDto);
            }else{
                cliente.setPlan(null);
            }
            //cliente.setPayment(clienteResp.getPayment());
            cliente.setEmpresa(empresaDto);
            clienteDtoList.add(cliente);
        }
        return new ResponseEntity(clienteDtoList, HttpStatus.OK);
    }

    public ResponseEntity getClientByCompany(long idempresa){
        ClientResponse clienteResponse = new ClientResponse();
        List<ClientDto> resp = clienteRepository.findByEmpresaId(idempresa);

        List<ClientDto> clienteDtoList = new ArrayList<ClientDto>();
        EmpresaDto empresaDto = new EmpresaDto();

        //Optional<EmpresaDto> respEmpresa = empresaRepository.findById(newCliente.getIdEmpresa());
        for (int i = 0; i<resp.size();i++){
            ClientDto cliente = new ClientDto();

            ClientDto clienteResp = resp.get(i);

            empresaDto.setId(clienteResp.getEmpresa().getId());
            empresaDto.setNombre(clienteResp.getEmpresa().getNombre());
            empresaDto.setRut(clienteResp.getEmpresa().getRut());
            empresaDto.setDireccion(clienteResp.getEmpresa().getDireccion());

            cliente.setRut(clienteResp.getRut());
            cliente.setAddress(clienteResp.getAddress());
            cliente.setComuna(clienteResp.getComuna());
            cliente.setCity(clienteResp.getCity());
            cliente.setComuna(clienteResp.getComuna());
            cliente.setAuxiliarPhone(clienteResp.getAuxiliarPhone());
            cliente.setEmail(clienteResp.getEmail());
            cliente.setBirthDate(clienteResp.getBirthDate());
            cliente.setRut(clienteResp.getRut());
            cliente.setEmail(clienteResp.getEmail());
            cliente.setEnabled(clienteResp.isEnabled());
            cliente.setExpiredAt(clienteResp.getExpiredAt());
            cliente.setName(clienteResp.getName());
            cliente.setPhone(clienteResp.getPhone());

            List<PaymentsDto> paymentsDtoList = paymentRepository.findByRutCliente(clienteResp.getRut());

            if(!paymentsDtoList.isEmpty()){
                cliente.setPayment(paymentsDtoList);
            }

            if(clienteResp.getPlan() != null){
                PlanDto planDto = new PlanDto();
                planDto.setId(clienteResp.getPlan().getId());
                planDto.setDescription(clienteResp.getPlan().getDescription());
                planDto.setEnabled(clienteResp.getPlan().isEnabled());
                planDto.setName(clienteResp.getPlan().getName());
                planDto.setPeriod(clienteResp.getPlan().getPeriod());
                planDto.setPrice(clienteResp.getPlan().getPrice());
                
                //cliente.setPlan(clienteResp.getPlan());
                cliente.setPlan(planDto);
            }else{
                cliente.setPlan(null);
            }

            //cliente.setPayment(clienteResp.getPayment());
            cliente.setEmpresa(empresaDto);

            cliente.setEmpresa(empresaDto);
            clienteDtoList.add(cliente);
        }
        return new ResponseEntity(clienteDtoList,HttpStatus.OK);
    }

    public ResponseEntity getClientByRut(String rut){
        Optional<ClientDto> clientes = clienteRepository.findByRutAndHabilitado(rut);
        if(clientes.isPresent()){
            ClientDto cliente= new ClientDto();
            EmpresaDto empresaDto = new EmpresaDto();

            ClientDto clienteResp = clientes.get();
            empresaDto.setId(clienteResp.getEmpresa().getId());
            empresaDto.setNombre(clienteResp.getEmpresa().getNombre());
            empresaDto.setRut(clienteResp.getEmpresa().getRut());
            empresaDto.setDireccion(clienteResp.getEmpresa().getDireccion());

            cliente.setRut(clienteResp.getRut());
            cliente.setAddress(clienteResp.getAddress());
            cliente.setComuna(clienteResp.getComuna());
            cliente.setCity(clienteResp.getCity());
            cliente.setComuna(clienteResp.getComuna());
            cliente.setAuxiliarPhone(clienteResp.getAuxiliarPhone());
            cliente.setEmail(clienteResp.getEmail());
            cliente.setBirthDate(clienteResp.getBirthDate());
            cliente.setRut(clienteResp.getRut());
            cliente.setEmail(clienteResp.getEmail());
            cliente.setEnabled(clienteResp.isEnabled());
            cliente.setExpiredAt(clienteResp.getExpiredAt());
            cliente.setName(clienteResp.getName());
            cliente.setPhone(clienteResp.getPhone());


            List<PaymentsDto> paymentsDtoList = paymentRepository.findByRutCliente(clienteResp.getRut());

            if(!paymentsDtoList.isEmpty()){
                cliente.setPayment(paymentsDtoList);
            }

            if(clienteResp.getPlan() != null){
                PlanDto planDto = new PlanDto();
                planDto.setId(clienteResp.getPlan().getId());
                planDto.setDescription(clienteResp.getPlan().getDescription());
                planDto.setEnabled(clienteResp.getPlan().isEnabled());
                planDto.setName(clienteResp.getPlan().getName());
                planDto.setPeriod(clienteResp.getPlan().getPeriod());
                planDto.setPrice(clienteResp.getPlan().getPrice());

                //cliente.setPlan(clienteResp.getPlan());
                cliente.setPlan(planDto);
            }else{
                cliente.setPlan(null);
            }
            //cliente.setPayment(clienteResp.getPayment());
            cliente.setEmpresa(empresaDto);
            cliente.setEmpresa(empresaDto);
            return new ResponseEntity(cliente,HttpStatus.OK);

        }else{
            return new ResponseEntity("Cliente no se encuentra",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity getClientByName(String name){
        Optional<ClientDto> clientes = clienteRepository.getClientByName(name);;
        if(clientes.isPresent()){
            ClientDto cliente= new ClientDto();
            EmpresaDto empresaDto = new EmpresaDto();

            ClientDto clienteResp = clientes.get();
            empresaDto.setId(clienteResp.getEmpresa().getId());
            empresaDto.setNombre(clienteResp.getEmpresa().getNombre());
            empresaDto.setRut(clienteResp.getEmpresa().getRut());
            empresaDto.setDireccion(clienteResp.getEmpresa().getDireccion());

            cliente.setRut(clienteResp.getRut());
            cliente.setAddress(clienteResp.getAddress());
            cliente.setComuna(clienteResp.getComuna());
            cliente.setCity(clienteResp.getCity());
            cliente.setComuna(clienteResp.getComuna());
            cliente.setAuxiliarPhone(clienteResp.getAuxiliarPhone());
            cliente.setEmail(clienteResp.getEmail());
            cliente.setBirthDate(clienteResp.getBirthDate());
            cliente.setRut(clienteResp.getRut());
            cliente.setEmail(clienteResp.getEmail());
            cliente.setEnabled(clienteResp.isEnabled());
            cliente.setExpiredAt(clienteResp.getExpiredAt());
            cliente.setName(clienteResp.getName());
            cliente.setPhone(clienteResp.getPhone());


            List<PaymentsDto> paymentsDtoList = paymentRepository.findByRutCliente(clienteResp.getRut());

            if(!paymentsDtoList.isEmpty()){
                cliente.setPayment(paymentsDtoList);
            }

            if(clienteResp.getPlan() != null){
                PlanDto planDto = new PlanDto();
                planDto.setId(clienteResp.getPlan().getId());
                planDto.setDescription(clienteResp.getPlan().getDescription());
                planDto.setEnabled(clienteResp.getPlan().isEnabled());
                planDto.setName(clienteResp.getPlan().getName());
                planDto.setPeriod(clienteResp.getPlan().getPeriod());
                planDto.setPrice(clienteResp.getPlan().getPrice());

                //cliente.setPlan(clienteResp.getPlan());
                cliente.setPlan(planDto);
            }else{
                cliente.setPlan(null);
            }
            //cliente.setPayment(clienteResp.getPayment());
            cliente.setEmpresa(empresaDto);
            cliente.setEmpresa(empresaDto);
            return new ResponseEntity(cliente,HttpStatus.OK);

        }else{
            return new ResponseEntity("Cliente no se encuentra",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity getClienteByLikeRut(String rut){
        Optional<ClientDto> clientes = clienteRepository.getClienteByLikeRut(rut);
        if(clientes.isPresent()){
            ClientDto cliente= new ClientDto();
            EmpresaDto empresaDto = new EmpresaDto();

            ClientDto clienteResp = clientes.get();
            empresaDto.setId(clienteResp.getEmpresa().getId());
            empresaDto.setNombre(clienteResp.getEmpresa().getNombre());
            empresaDto.setRut(clienteResp.getEmpresa().getRut());
            empresaDto.setDireccion(clienteResp.getEmpresa().getDireccion());

            cliente.setRut(clienteResp.getRut());
            cliente.setAddress(clienteResp.getAddress());
            cliente.setComuna(clienteResp.getComuna());
            cliente.setCity(clienteResp.getCity());
            cliente.setComuna(clienteResp.getComuna());
            cliente.setAuxiliarPhone(clienteResp.getAuxiliarPhone());
            cliente.setEmail(clienteResp.getEmail());
            cliente.setBirthDate(clienteResp.getBirthDate());
            cliente.setRut(clienteResp.getRut());
            cliente.setEmail(clienteResp.getEmail());
            cliente.setEnabled(clienteResp.isEnabled());
            cliente.setExpiredAt(clienteResp.getExpiredAt());
            cliente.setName(clienteResp.getName());
            cliente.setPhone(clienteResp.getPhone());


            List<PaymentsDto> paymentsDtoList = paymentRepository.findByRutCliente(clienteResp.getRut());

            if(!paymentsDtoList.isEmpty()){
                cliente.setPayment(paymentsDtoList);
            }

            if(clienteResp.getPlan() != null){
                PlanDto planDto = new PlanDto();
                planDto.setId(clienteResp.getPlan().getId());
                planDto.setDescription(clienteResp.getPlan().getDescription());
                planDto.setEnabled(clienteResp.getPlan().isEnabled());
                planDto.setName(clienteResp.getPlan().getName());
                planDto.setPeriod(clienteResp.getPlan().getPeriod());
                planDto.setPrice(clienteResp.getPlan().getPrice());

                //cliente.setPlan(clienteResp.getPlan());
                cliente.setPlan(planDto);
            }else{
                cliente.setPlan(null);
            }
            //cliente.setPayment(clienteResp.getPayment());
            cliente.setEmpresa(empresaDto);
            cliente.setEmpresa(empresaDto);
            return new ResponseEntity(cliente,HttpStatus.OK);

        }else{
            return new ResponseEntity("Cliente no se encuentra",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity createClient(com.gimnasio.planetaFitness.request.ClientRequest newCliente){
        Optional<ClientDto> clienteDtoOptional = Optional.empty();
        try {
            clienteDtoOptional = clienteRepository.findByRutAndHabilitadoAndEmpresa(newCliente.getRut(), newCliente.getIdEmpresa());
        }catch (InvalidDataAccessResourceUsageException e){
            e.printStackTrace();
        }
        if (clienteDtoOptional.isPresent()){
            if (!clienteDtoOptional.get().isEnabled()){
                return new ResponseEntity("Cliente ya se encuentra registrado y esta deshabilitado",HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity("Cliente ya existe para esta empresa",HttpStatus.BAD_REQUEST);
        }

        ClientDto cliente = new ClientDto();
        Optional<EmpresaDto> respEmpresa = empresaRepository.findById(newCliente.getIdEmpresa());
        Optional<PlanDto> respPlan = planRepository.findById(newCliente.getIdPlan());

        Optional<PaymentsDto> respPayment = paymentRepository.findById(newCliente.getIdPayment());

        if(respEmpresa.isPresent()) {
            cliente.setRut(newCliente.getRut());
            cliente.setAddress(newCliente.getAddress());
            cliente.setComuna(newCliente.getComuna());
            cliente.setCity(newCliente.getCity());
            cliente.setComuna(newCliente.getComuna());
            cliente.setAuxiliarPhone(newCliente.getAuxiliarPhone());
            //cliente.setEmail(newCliente.getEmail());
            cliente.setBirthDate(newCliente.getBirthDate());
            cliente.setRut(newCliente.getRut());
            cliente.setEmail(newCliente.getEmail());
            cliente.setEnabled(true);
            cliente.setExpiredAt(newCliente.getExpiredAt());
            cliente.setName(newCliente.getName());
            cliente.setPhone(newCliente.getPhone());
            cliente.setPlan(respPlan.get());
            //cliente.setPayment(respPayment.isPresent()?Collections.singletonList(respPayment.get()):Collections.emptyList());
            cliente.setEmpresa(respEmpresa.get());
        }else{
            return new ResponseEntity("Error Empresa no existe",HttpStatus.BAD_REQUEST);
        }
        try {
            clienteRepository.save(cliente);
        }catch (Exception e){
            return new ResponseEntity("Error interno al crear Cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<ClientDto>(cliente, HttpStatus.CREATED);
    }

    public ResponseEntity updateClient(com.gimnasio.planetaFitness.request.ClientRequest newCliente){
        ClientDto cliente = new ClientDto();
        EmpresaDto empresaDto = new EmpresaDto();

        Optional<EmpresaDto> respEmpresa = empresaRepository.findById(newCliente.getIdEmpresa());
        Optional<PlanDto> respPlan = planRepository.findById(newCliente.getIdPlan());

        Optional<PaymentsDto> respPayment = paymentRepository.findById(newCliente.getIdPayment());


        if(respEmpresa.isPresent()) {
            cliente.setRut(newCliente.getRut());
            cliente.setAddress(newCliente.getAddress());
            cliente.setComuna(newCliente.getComuna());
            cliente.setCity(newCliente.getCity());
            cliente.setComuna(newCliente.getComuna());
            cliente.setAuxiliarPhone(newCliente.getAuxiliarPhone());
            cliente.setBirthDate(newCliente.getBirthDate());
            cliente.setRut(newCliente.getRut());
            cliente.setEmail(newCliente.getEmail());
            //cliente.setEnabled(newCliente.isEnabled());
            cliente.setExpiredAt(newCliente.getExpiredAt());
            cliente.setName(newCliente.getName());
            cliente.setPhone(newCliente.getPhone());

            

            cliente.setPlan(respPlan.isPresent()?respPlan.get():null);


            //cliente.setPayment(respPayment.isPresent()?Collections.singletonList(respPayment.get()):Collections.emptyList());
            cliente.setEmpresa(respEmpresa.get());
        }else{
            return new ResponseEntity("Error Empresa no existe",HttpStatus.BAD_REQUEST);
        }

        clienteRepository.save(cliente);

        return new ResponseEntity(cliente, HttpStatus.CREATED);
    }

    public ResponseEntity deleteClient(com.gimnasio.planetaFitness.request.ClientRequest newCliente){
        Optional<ClientDto> clienteOptional = clienteRepository.findByRut(newCliente.getRut());
        ClientDto cliente = clienteOptional.isPresent()?clienteOptional.get():null;
        if(cliente != null){
            cliente.setEnabled(false);
            clienteRepository.save(cliente);
            return new ResponseEntity(cliente,HttpStatus.OK);
        }
        /*Optional<EmpresaDto> respEmpresa = empresaRepository.findById(newCliente.getIdEmpresa());

        if(respEmpresa.isPresent()) {
            cliente.setId(newCliente.getId());
            cliente.setHabilitado(0);
            cliente.setApellido(newCliente.getApellido());
            cliente.setCiudad(newCliente.getCiudad());
            cliente.setComuna(newCliente.getComuna());
            cliente.setDireccion(newCliente.getDireccion());
            cliente.setEmail(newCliente.getEmail());
            cliente.setNombre(newCliente.getNombre());
            cliente.setRut(newCliente.getRut());
            cliente.setTelefono(newCliente.getTelefono());
            cliente.setEmpresa(respEmpresa.get());
        }else{
            return new ResponseEntity("Error Empresa no existe",HttpStatus.BAD_REQUEST);
        }

        try {
            clienteRepository.save(cliente);
        }catch (Exception e){
            return new ResponseEntity("Error interno al eliminar cliente",HttpStatus.INTERNAL_SERVER_ERROR);
        }*/
        return new ResponseEntity("Cliente no encontrado", HttpStatus.BAD_REQUEST);
    }

}
