package com.goktug.cargallerist.controller.impl;

import com.goktug.cargallerist.controller.IRestGalleristController;
import com.goktug.cargallerist.controller.RestBaseController;
import com.goktug.cargallerist.controller.RootEntity;
import com.goktug.cargallerist.dto.DtoGallerist;
import com.goktug.cargallerist.dto.DtoGalleristIU;
import com.goktug.cargallerist.service.IGalleristService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/api/gallerist")
public class RestGalleristControllerImpl extends RestBaseController implements IRestGalleristController {

    @Autowired
    private IGalleristService galleristService;

    @Override
    @PostMapping(value = "/save")
    public RootEntity<DtoGallerist> saveGallerist(@Valid @RequestBody DtoGalleristIU dtoGalleristIU) {
        return ok(galleristService.saveGallerist(dtoGalleristIU));
    }
}
