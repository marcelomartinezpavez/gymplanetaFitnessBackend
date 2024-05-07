package com.gimnasio.planetaFitness.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "minuto")
public class MinutoDto {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "minuto")
    private String minuto;

    @OneToMany(fetch = FetchType.EAGER)
    @Column(name = "reserva")
    private Set<ReservaDto> reserva;

    public MinutoDto(String id, String minuto, Set<ReservaDto> reserva) {
        this.id = id;
        this.minuto = minuto;
        this.reserva = reserva;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }

    public Set<ReservaDto> getReserva() {
        return reserva;
    }

    public void setReserva(Set<ReservaDto> reserva) {
        this.reserva = reserva;
    }
}
