package com.gimnasio.planetaFitness.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "hora")
public class HoraDto {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "hora")
    private String hora;

    @OneToMany(fetch = FetchType.EAGER)
    @Column(name = "reserva")
    private Set<ReservaDto> reserva;

    public HoraDto(String id, String hora, Set<ReservaDto> reserva) {
        this.id = id;
        this.hora = hora;
        this.reserva = reserva;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Set<ReservaDto> getReserva() {
        return reserva;
    }

    public void setReserva(Set<ReservaDto> reserva) {
        this.reserva = reserva;
    }
}
