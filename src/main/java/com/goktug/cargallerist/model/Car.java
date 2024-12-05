package com.goktug.cargallerist.model;

import com.goktug.cargallerist.enums.CarStatusType;
import com.goktug.cargallerist.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "car")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car extends BaseEntity{

    @Column(name = "plaka")
    private String plaka;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "productionYear")
    private Integer productionYear;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "currencyType")
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;

    @Column(name = "damagePrice")
    private BigDecimal damagePrice;

    @Column(name = "carStatusType")
    @Enumerated(EnumType.STRING)
    private CarStatusType carStatusType;
}
