package com.gimnasio.planetaFitness.mapper;

import com.gimnasio.planetaFitness.dto.ClientDto;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

public class EmpresaMapper {
    private long id;
    private String direccion;
    private String nombre;
    private String rut;
    private Set<ClientDto> clients;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Set<ClientDto> getClients() {
        return clients;
    }

    public void setClients(Set<ClientDto> clients) {
        this.clients = clients;
    }
}
