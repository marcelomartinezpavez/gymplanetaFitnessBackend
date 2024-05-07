package com.gimnasio.planetaFitness.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "anio")
public class AnioDto {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "anio")
    private int anio;

    @OneToMany(fetch = FetchType.EAGER)
    @Column(name = "reserva")
    private Set<ReservaDto> reserva;

    public AnioDto(String id, int anio, Set<ReservaDto> reserva) {
        this.id = id;
        this.anio = anio;
        this.reserva = reserva;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Set<ReservaDto> getReserva() {
        return reserva;
    }

    public void setReserva(Set<ReservaDto> reserva) {
        this.reserva = reserva;
    }
}
