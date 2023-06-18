package com.gimnasio.planetaFitness.request;

import com.gimnasio.planetaFitness.dto.ClientDto;
import com.gimnasio.planetaFitness.dto.EmpresaDto;
import com.gimnasio.planetaFitness.dto.PlanDto;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

public class PaymentRequest {

    private long id;
    private Date date;
    private Date expiredAt;
    private long price;
    private String typeOfPayment;
    private String rutClient;
    private long idPlan;
    private long idEmpresa;

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

    public String getRutClient() {
        return rutClient;
    }

    public void setRutClient(String rutClient) {
        this.rutClient = rutClient;
    }

    public long getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(long idPlan) {
        this.idPlan = idPlan;
    }

    public long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
