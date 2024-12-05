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
}
