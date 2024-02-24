package com.gimnasio.planetaFitness.mapper;


import com.gimnasio.planetaFitness.dto.EmpresaDto;
import com.gimnasio.planetaFitness.dto.PaymentsDto;
import com.gimnasio.planetaFitness.dto.PlanDto;


import java.sql.Date;
import java.util.List;

public class ClientMapper {

    private Long numberClient;
    private String rut;
    private String address;
    private String comuna;
    private String city;
    private String auxiliarPhone;
    private Date birthDate;
    private String email;
    private boolean enabled;
    private Date expiredAt;
    private String name;
    private String phone;
    private PlanDto plan;
    private List<PaymentsDto> payment;
    private EmpresaDto empresa;

    public Long getNumberClient() {
        return numberClient;
    }

    public void setNumberClient(Long numberClient) {
        this.numberClient = numberClient;
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

    public List<PaymentsDto> getPayment() {
        return payment;
    }

    public void setPayment(List<PaymentsDto> payment) {
        this.payment = payment;
    }

    public EmpresaDto getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDto empresa) {
        this.empresa = empresa;
    }
}
