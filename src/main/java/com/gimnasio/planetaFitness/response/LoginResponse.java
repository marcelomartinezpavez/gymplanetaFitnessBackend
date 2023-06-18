package com.gimnasio.planetaFitness.response;

import com.gimnasio.planetaFitness.dto.EmpresaDto;
import com.gimnasio.planetaFitness.dto.UsersDto;

public class LoginResponse {

    private UsersDto users;
    private EmpresaDto empresa;

    public EmpresaDto getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDto empresa) {
        this.empresa = empresa;
    }

    public UsersDto getUsers() {
        return users;
    }

    public void setUsers(UsersDto users) {
        this.users = users;
    }
}
