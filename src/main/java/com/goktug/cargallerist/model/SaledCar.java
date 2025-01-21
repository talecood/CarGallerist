package com.goktug.cargallerist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "saled_car",uniqueConstraints = {@UniqueConstraint(columnNames =
        {"gallerist_id","car_id","customer_id"},
        name = "uq_gallerist_car_customer")})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaledCar extends BaseEntity{

    @ManyToOne
    private Gallerist gallerist;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Gallerist getGallerist() {
        return gallerist;
    }

    public void setGallerist(Gallerist gallerist) {
        this.gallerist = gallerist;
    }
}
