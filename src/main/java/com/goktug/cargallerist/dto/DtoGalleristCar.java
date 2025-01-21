package com.goktug.cargallerist.dto;

import java.util.Optional;

public class DtoGalleristCar {

    private DtoGallerist dtoGallerist;

    private DtoCar dtoCar;

    public DtoGallerist getDtoGallerist() {
        return dtoGallerist;
    }

    public void setDtoGallerist(DtoGallerist dtoGallerist) {
        this.dtoGallerist = dtoGallerist;
    }

    public DtoCar getDtoCar() {
        return dtoCar;
    }

    public void setDtoCar(Optional<DtoCar> dtoCar) {
        this.dtoCar = dtoCar.get();
    }
}
