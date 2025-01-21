package com.goktug.cargallerist.controller;

import com.goktug.cargallerist.dto.DtoCar;
import com.goktug.cargallerist.dto.DtoCarIU;

public interface IRestCarController {

    RootEntity<DtoCar> saveCar(DtoCarIU dtoCarIU);
}
