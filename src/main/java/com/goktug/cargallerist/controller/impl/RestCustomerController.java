package com.goktug.cargallerist.controller.impl;

import com.goktug.cargallerist.controller.IRestCustomerController;
import com.goktug.cargallerist.controller.RestBaseController;
import com.goktug.cargallerist.controller.RootEntity;
import com.goktug.cargallerist.dto.DtoCustomer;
import com.goktug.cargallerist.dto.DtoCustomerIU;
import com.goktug.cargallerist.service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.goktug.cargallerist.controller.RootEntity.ok;

@RestController
@RequestMapping(value = "/rest/api/customer")
public class RestCustomerController extends RestBaseController implements IRestCustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping(value = "/save")
    @Override
    public RootEntity<DtoCustomer> saveCustomer(@Valid @RequestBody DtoCustomerIU dtoCustomerIU) {
        return ok(customerService.saveCustomer(dtoCustomerIU));
    }
}
