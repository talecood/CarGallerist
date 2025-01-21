package com.goktug.cargallerist.dto;

import jakarta.validation.constraints.NotNull;

public class DtoGalleristCarIU {

    @NotNull
    private Long galleristId;

    @NotNull
    private Long carId;

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
