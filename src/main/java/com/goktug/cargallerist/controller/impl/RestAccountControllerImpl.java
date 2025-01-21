package com.goktug.cargallerist.controller.impl;

import com.goktug.cargallerist.controller.IRestAccountController;
import com.goktug.cargallerist.controller.RestBaseController;
import com.goktug.cargallerist.controller.RootEntity;
import com.goktug.cargallerist.dto.DtoAccount;
import com.goktug.cargallerist.dto.DtoAccountIU;
import com.goktug.cargallerist.service.IAccountService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/api/account")
public class RestAccountControllerImpl extends RestBaseController implements IRestAccountController {

    @Autowired
    private IAccountService accountService;

    @PostMapping(value = "/save")
    @Override
    public RootEntity<DtoAccount> saveAccount(@Valid @RequestBody DtoAccountIU dtoAccountIU) {
        return ok(accountService.saveAccount(dtoAccountIU));
    }
}
