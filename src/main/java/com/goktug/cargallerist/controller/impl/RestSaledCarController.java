package com.goktug.cargallerist.controller.impl;

import com.goktug.cargallerist.controller.IRestSaledCarController;
import com.goktug.cargallerist.controller.RestBaseController;
import com.goktug.cargallerist.controller.RootEntity;
import com.goktug.cargallerist.dto.DtoSaledCar;
import com.goktug.cargallerist.dto.DtoSaledCarIU;
import com.goktug.cargallerist.service.ISaledCarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/api/saled-car")
public class RestSaledCarController extends RestBaseController implements IRestSaledCarController {

    @Autowired
    private ISaledCarService saledCarService;


    @PostMapping(value = "/save")
    @Override
    public RootEntity<DtoSaledCar> buyCar(@Valid @RequestBody DtoSaledCarIU dtoSaledCarIU) {
        return ok(saledCarService.buyCar(dtoSaledCarIU));
    }
}
