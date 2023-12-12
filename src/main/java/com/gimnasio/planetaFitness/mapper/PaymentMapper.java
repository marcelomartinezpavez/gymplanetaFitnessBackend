package com.gimnasio.planetaFitness.mapper;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gimnasio.planetaFitness.dto.ClientDto;
import com.gimnasio.planetaFitness.dto.EmpresaDto;
import com.gimnasio.planetaFitness.dto.PlanDto;

import javax.persistence.*;
import java.sql.Date;

public class PaymentMapper {

    private long id;
    private Date date;
    private Date expiredAt;
    private long price;
    private String typeOfPayment;

    private ClientMapper client;

    private PlanMapper plan;
    private EmpresaMapper empresa;

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

    public ClientMapper getClient() {
        return client;
    }

    public void setClient(ClientMapper client) {
        this.client = client;
    }

    public PlanMapper getPlan() {
        return plan;
    }

    public void setPlan(PlanMapper plan) {
        this.plan = plan;
    }

    public EmpresaMapper getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaMapper empresa) {
        this.empresa = empresa;
    }
}
