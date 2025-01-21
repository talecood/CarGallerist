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


    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public BigDecimal getDamagePrice() {
        return damagePrice;
    }

    public void setDamagePrice(BigDecimal damagePrice) {
        this.damagePrice = damagePrice;
    }

    public CarStatusType getCarStatusType() {
        return carStatusType;
    }

    public void setCarStatusType(CarStatusType carStatusType) {
        this.carStatusType = carStatusType;
    }
}
