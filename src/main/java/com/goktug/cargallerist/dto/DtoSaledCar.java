package com.goktug.cargallerist.dto;

public class DtoSaledCar extends DtoBase{

    private DtoCar car;

    private DtoGallerist gallerist;

    private DtoCustomer customer;

    public DtoCar getCar() {
        return car;
    }

    public void setCar(DtoCar car) {
        this.car = car;
    }

    public DtoGallerist getGallerist() {
        return gallerist;
    }

    public void setGallerist(DtoGallerist gallerist) {
        this.gallerist = gallerist;
    }

    public DtoCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(DtoCustomer customer) {
        this.customer = customer;
    }
}
