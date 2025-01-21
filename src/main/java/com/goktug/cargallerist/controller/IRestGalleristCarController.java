package com.goktug.cargallerist.controller;

import com.goktug.cargallerist.dto.DtoGalleristCar;
import com.goktug.cargallerist.dto.DtoGalleristCarIU;

public interface IRestGalleristCarController {
    RootEntity<DtoGalleristCar> saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);
}
