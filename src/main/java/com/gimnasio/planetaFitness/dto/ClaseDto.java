package com.gimnasio.planetaFitness.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "clase")
public class ClaseDto {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cantidad_alumnos")
    private String cantidadAlumnos;

    @Column(name = "disponibles")
    private String disponibles;

    @Column(name = "dia")
    private String dia;

    @OneToMany(fetch = FetchType.EAGER)
    @Column(name = "reserva")
    private Set<ReservaDto> reserva;



    public ClaseDto(String id, String nombre, String cantidadAlumnos, String disponibles, String dia, Set<ReservaDto> reserva) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadAlumnos = cantidadAlumnos;
        this.disponibles = disponibles;
        this.dia = dia;
        this.reserva = reserva;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(String cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public String getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(String disponibles) {
        this.disponibles = disponibles;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Set<ReservaDto> getReserva() {
        return reserva;
    }

    public void setReserva(Set<ReservaDto> reserva) {
        this.reserva = reserva;
    }

}
