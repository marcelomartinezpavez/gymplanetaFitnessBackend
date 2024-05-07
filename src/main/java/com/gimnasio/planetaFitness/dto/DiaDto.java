package com.gimnasio.planetaFitness.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "dia")
public class DiaDto {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "dia")
    private int dia;

    @OneToMany(fetch = FetchType.EAGER)
    @Column(name = "reserva")
    private Set<ReservaDto> reserva;

    public DiaDto(String id, int dia, Set<ReservaDto> reserva) {
        this.id = id;
        this.dia = dia;
        this.reserva = reserva;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public Set<ReservaDto> getReserva() {
        return reserva;
    }

    public void setReserva(Set<ReservaDto> reserva) {
        this.reserva = reserva;
    }
}
