package com.goktug.cargallerist.dto;

public class DtoSaledCarIU {

    private Long customerId;

    private Long galleristId;

    private Long carId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getGalleristId() {
        return galleristId;
    }

    public void setGalleristId(Long galleristId) {
        this.galleristId = galleristId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }
}
