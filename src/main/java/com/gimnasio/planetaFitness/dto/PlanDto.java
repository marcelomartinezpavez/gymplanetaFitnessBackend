package com.gimnasio.planetaFitness.dto;

//import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "plan")
public class PlanDto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "description")
    private String description;
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "name")
    private String name;
    @Column(name = "period")
    private String period;
    @Column(name = "price")
    private long price;

    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "client_rut", referencedColumnName = "rut")

    /*@OneToMany(mappedBy = "plan")
    private Set<ClientDto> clients;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private PaymentsDto payments;
    */


    public PlanDto(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
/*
    public Set<ClientDto> getClients() {
        return clients;
    }

    public void setClients(Set<ClientDto> clients) {
        this.clients = clients;
    }

    public PaymentsDto getPayments() {
        return payments;
    }

    public void setPayments(PaymentsDto payments) {
        this.payments = payments;
    }
    */
}
