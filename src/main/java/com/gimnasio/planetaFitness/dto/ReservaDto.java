package com.gimnasio.planetaFitness.dto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reserva")
public class ReservaDto {

    @Id
    @Column(name = "id")
    private String id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private ClaseDto clase;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rut")
    private ClientDto client;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private DiaDto dia;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private MesDto mes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private AnioDto anio;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private HoraDto hora;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private MinutoDto minuto;

    public ReservaDto(String id,ClaseDto clase, ClientDto client, DiaDto dia, MesDto mes, AnioDto anio, HoraDto hora, MinutoDto minuto) {
        this.id = id;
        this.clase = clase;
        this.client = client;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.hora = hora;
        this.minuto = minuto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ClaseDto getClase() {
        return clase;
    }

    public void setClase(ClaseDto clase) {
        this.clase = clase;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public DiaDto getDia() {
        return dia;
    }

    public void setDia(DiaDto dia) {
        this.dia = dia;
    }

    public MesDto getMes() {
        return mes;
    }

    public void setMes(MesDto mes) {
        this.mes = mes;
    }

    public AnioDto getAnio() {
        return anio;
    }

    public void setAnio(AnioDto anio) {
        this.anio = anio;
    }

    public HoraDto getHora() {
        return hora;
    }

    public void setHora(HoraDto hora) {
        this.hora = hora;
    }

    public MinutoDto getMinuto() {
        return minuto;
    }

    public void setMinuto(MinutoDto minuto) {
        this.minuto = minuto;
    }
}
