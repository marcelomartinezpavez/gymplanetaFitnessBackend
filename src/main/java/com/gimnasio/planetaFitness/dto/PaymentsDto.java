package com.gimnasio.planetaFitness.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

//@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "payments")
public class PaymentsDto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "date")
    private Date date;
    @Column(name = "expiredAt")
    private Date expiredAt;
    @Column(name = "price")
    private long price;
    @Column(name = "typeOfPayment")
    private String typeOfPayment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rut")
    @JsonBackReference
    private ClientDto client;


    @ManyToOne(fetch = FetchType.LAZY)
    private PlanDto plan;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")
    private EmpresaDto empresa;

    public PaymentsDto(){}

    public PaymentsDto(long id, Date date, Date expiredAt, long price, String typeOfPayment, ClientDto client, PlanDto plan, String codigoRepuestos){
        super();
        this.id= id;
        this.date = date;
        this.expiredAt = expiredAt;
        this.price = price;
        this.typeOfPayment = typeOfPayment;
        this.client = client;
        this.plan = plan;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(Date expiredAt) {
        this.expiredAt = expiredAt;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getTypeOfPayment() {
        return typeOfPayment;
    }

    public void setTypeOfPayment(String typeOfPayment) {
        this.typeOfPayment = typeOfPayment;
    }

    //@JsonBackReference
    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public PlanDto getPlan() {
        return plan;
    }

    public void setPlan(PlanDto plan) {
        this.plan = plan;
    }

    public EmpresaDto getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDto empresa) {
        this.empresa = empresa;
    }
}
