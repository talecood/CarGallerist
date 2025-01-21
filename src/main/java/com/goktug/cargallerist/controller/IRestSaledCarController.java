package com.goktug.cargallerist.controller;

import com.goktug.cargallerist.dto.DtoSaledCar;
import com.goktug.cargallerist.dto.DtoSaledCarIU;

public interface IRestSaledCarController {

    public RootEntity<DtoSaledCar> buyCar(DtoSaledCarIU dtoSaledCarIU);
}
