package com.goktug.cargallerist.dto;


import com.goktug.cargallerist.enums.CarStatusType;
import com.goktug.cargallerist.enums.CurrencyType;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class DtoCarIU {

    @NotNull
    private String plaka;

    @NotNull
    private String brand;

    @NotNull
    private String model;

    @NotNull
    private Integer productionYear;

    @NotNull
    private BigDecimal price;

    @NotNull
    private CurrencyType currencyType;

    @NotNull
    private BigDecimal damagePrice;

    @NotNull
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
