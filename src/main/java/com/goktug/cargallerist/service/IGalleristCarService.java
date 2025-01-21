package com.goktug.cargallerist.service;

import com.goktug.cargallerist.dto.DtoGalleristCar;
import com.goktug.cargallerist.dto.DtoGalleristCarIU;

public interface IGalleristCarService {
    public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);
}
