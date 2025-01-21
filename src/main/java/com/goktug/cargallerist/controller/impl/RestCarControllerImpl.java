package com.goktug.cargallerist.controller.impl;

import com.goktug.cargallerist.controller.IRestCarController;
import com.goktug.cargallerist.controller.RestBaseController;
import com.goktug.cargallerist.controller.RootEntity;
import com.goktug.cargallerist.dto.DtoCar;
import com.goktug.cargallerist.dto.DtoCarIU;
import com.goktug.cargallerist.service.ICarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/api/car")
public class RestCarControllerImpl extends RestBaseController implements IRestCarController {

    @Autowired
    private ICarService carService;

    @PostMapping(value = "/save")
    @Override
    public RootEntity<DtoCar> saveCar(@Valid @RequestBody DtoCarIU dtoCarIU) {
        return ok(carService.saveCar(dtoCarIU));
    }
}
