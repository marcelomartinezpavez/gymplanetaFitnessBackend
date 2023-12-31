package com.gimnasio.planetaFitness.controller;

import com.gimnasio.planetaFitness.dto.EmpresaDto;
import com.gimnasio.planetaFitness.dto.UsersDto;
import com.gimnasio.planetaFitness.repository.EmpresaRepository;
import com.gimnasio.planetaFitness.repository.LoginRepository;
import com.gimnasio.planetaFitness.request.EmpresaAndUser;
import com.gimnasio.planetaFitness.request.Users;
import com.gimnasio.planetaFitness.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    EmpresaRepository empresaRepository;


    @PostMapping(path = "/",produces = "application/json")
    @CrossOrigin(origins = "*")
    public @ResponseBody
    ResponseEntity<UsersDto> login(@RequestBody Users newUsers) {
        Optional<UsersDto> resp = loginRepository.findByUsersAndPass(newUsers.getUsers(), newUsers.getPass());
        UsersDto usersDto = new UsersDto();
        EmpresaDto empresaDto = new EmpresaDto();
        if(!resp.isPresent()){
            return new ResponseEntity("Error al validar usuario",HttpStatus.BAD_REQUEST);
        }else{
            Optional<EmpresaDto> empresa = empresaRepository.findById(resp.get().getEmpresa().getId());
            //LoginResponse loginResponse = new LoginResponse();
            usersDto.setUsers(resp.get().getUsers());
            usersDto.setRol(resp.get().getRol());
            usersDto.setPass(resp.get().getPass());
            usersDto.setId(resp.get().getId());
            usersDto.setHabilitado(resp.get().getHabilitado());
            //loginResponse.setUsers(usersDto);
            if (empresa.isPresent()){
                empresaDto.setRut(empresa.get().getRut());
                empresaDto.setId(empresa.get().getId());
                empresaDto.setDireccion(empresa.get().getDireccion());
                empresaDto.setNombre(empresa.get().getNombre());
                usersDto.setEmpresa(empresaDto);
                //loginResponse.setEmpresa(empresaDto);
            }
            return new ResponseEntity<UsersDto>(usersDto, HttpStatus.OK);
        }
    }

    @PostMapping(path = "/create",produces = "application/json")
    @CrossOrigin(origins = "*")
    public @ResponseBody
    ResponseEntity<LoginResponse> create(@RequestBody EmpresaAndUser empresaAndUser) {
        Optional<EmpresaDto> empresa = empresaRepository.findByRut(empresaAndUser.getRutEmpresa());
        Optional<UsersDto> user = loginRepository.findByUsersAndPass(empresaAndUser.getUsers(), empresaAndUser.getPass());

        EmpresaDto empresaDto = new EmpresaDto();
        UsersDto users = new UsersDto();

        if (!user.isPresent()){

            users.setUsers(empresaAndUser.getUsers());
            users.setPass(empresaAndUser.getPass());
            users.setHabilitado(true);
            users.setRol(empresaAndUser.getRol());

            if(empresa.isPresent()) {
                empresaDto = empresa.get();
                users.setEmpresa(empresaDto);
                loginRepository.save(users);
            }else{
                //empresaDto.setUsers(users);
                empresaDto.setDireccion(empresaAndUser.getDireccionEmpresa());
                empresaDto.setNombre(empresaAndUser.getNombreEmpresa());
                empresaDto.setRut(empresaAndUser.getRutEmpresa());
                empresaRepository.save(empresaDto);
                users.setEmpresa(empresaDto);
                loginRepository.save(users);

            }
        }else{
            return new ResponseEntity("Usuario que intenta crear ya esta en uso",HttpStatus.IM_USED);
        }

        LoginResponse loginResponse = new LoginResponse();

        loginResponse.setUsers(users);
        loginResponse.setEmpresa(empresaDto);

        return new ResponseEntity(loginResponse, HttpStatus.OK);
    }

    @PostMapping(path = "/create/{idEmpresa}",produces = "application/json")
    @CrossOrigin(origins = "*")
    public @ResponseBody
    ResponseEntity<LoginResponse> createEmpresa(@RequestBody EmpresaAndUser empresaAndUser, @PathVariable long idEmpresa) {
        Optional<EmpresaDto> empresa = empresaRepository.findById(idEmpresa);
        Optional<UsersDto> user = loginRepository.findByUsersAndPass(empresaAndUser.getUsers(), empresaAndUser.getPass());

        EmpresaDto empresaDto = new EmpresaDto();
        UsersDto users = new UsersDto();

        if (!user.isPresent()){

            users.setUsers(empresaAndUser.getUsers());
            users.setPass(empresaAndUser.getPass());
            users.setHabilitado(true);
            users.setRol(empresaAndUser.getRol());

            if(empresa.isPresent()) {
                empresaDto = empresa.get();
                users.setEmpresa(empresaDto);
                loginRepository.save(users);
            }else{
                //empresaDto.setUsers(users);
                empresaDto.setDireccion(empresaAndUser.getDireccionEmpresa());
                empresaDto.setNombre(empresaAndUser.getNombreEmpresa());
                empresaDto.setRut(empresaAndUser.getRutEmpresa());
                empresaRepository.save(empresaDto);
                users.setEmpresa(empresaDto);
                loginRepository.save(users);

            }
        }else{
            return new ResponseEntity("Usuario que intenta crear ya esta en uso",HttpStatus.IM_USED);
        }

        LoginResponse loginResponse = new LoginResponse();

        loginResponse.setUsers(users);
        loginResponse.setEmpresa(empresaDto);

        return new ResponseEntity(loginResponse, HttpStatus.OK);
    }

}
