package com.goktug.cargallerist.service;

import com.goktug.cargallerist.dto.DtoCar;
import com.goktug.cargallerist.dto.DtoCarIU;

public interface ICarService {

    DtoCar saveCar(DtoCarIU dtoCarIU);
}
