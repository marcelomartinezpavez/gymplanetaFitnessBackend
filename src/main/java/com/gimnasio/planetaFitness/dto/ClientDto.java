package com.gimnasio.planetaFitness.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "clients")
public class ClientDto implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rut")
    private String rut;

    @Column(name = "address")
    private String address;

    @Column(name = "comuna")
    private String comuna;
    @Column(name = "city")
    private String city;
    @Column(name = "auxiliarPhone")
    private String auxiliarPhone;

    @Column(name = "birthDate")
    private Date birthDate;

    @Column(name = "email")
    private String email;

    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "expiredAt")
    private Date expiredAt;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    private PlanDto plan;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_payment", referencedColumnName = "id")
    private PaymentsDto payment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")
    private EmpresaDto empresa;

    public ClientDto(){}

    public ClientDto(String rut, String address, String comuna, String city, String auxiliarPhone, Date birthDate,
                     String email, boolean enabled, Date expiredAt, String name, String phone) {
        super();
        this.rut = rut;
        this.address = address;
        this.comuna = comuna;
        this.city = city;
        this.auxiliarPhone = auxiliarPhone;
        this.birthDate = birthDate;
        this.email = email;
        this.enabled = enabled;
        this.expiredAt = expiredAt;
        this.name = name;
        this.phone = phone;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAuxiliarPhone() {
        return auxiliarPhone;
    }

    public void setAuxiliarPhone(String auxiliarPhone) {
        this.auxiliarPhone = auxiliarPhone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(Date expiredAt) {
        this.expiredAt = expiredAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public PlanDto getPlan() {
        return plan;
    }

    public void setPlan(PlanDto plan) {
        this.plan = plan;
    }

    public PaymentsDto getPayment() {
        return payment;
    }

    public void setPayment(PaymentsDto payment) {
        this.payment = payment;
    }

    public EmpresaDto getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDto empresa) {
        this.empresa = empresa;
    }
}
