package com.goktug.cargallerist.controller.impl;

import com.goktug.cargallerist.controller.IRestAddressController;
import com.goktug.cargallerist.controller.RestBaseController;
import com.goktug.cargallerist.controller.RootEntity;
import com.goktug.cargallerist.dto.DtoAddress;
import com.goktug.cargallerist.dto.DtoAddressIU;
import com.goktug.cargallerist.service.IAddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/api/address")
public class RestAddressControllerImpl extends RestBaseController implements IRestAddressController {

    @Autowired
    private IAddressService iAddressService;

    @Override
    @PostMapping(value = "/save")
    public RootEntity<DtoAddress> saveAddress(@Valid @RequestBody DtoAddressIU dtoAddressIU) {
        return ok(iAddressService.saveAddress(dtoAddressIU));
    }
}
