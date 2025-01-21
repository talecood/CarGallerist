package com.goktug.cargallerist.service;

import com.goktug.cargallerist.dto.DtoSaledCar;
import com.goktug.cargallerist.dto.DtoSaledCarIU;

public interface ISaledCarService {

    public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU);
}
