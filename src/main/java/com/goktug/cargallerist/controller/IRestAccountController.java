package com.goktug.cargallerist.controller;

import com.goktug.cargallerist.dto.DtoAccount;
import com.goktug.cargallerist.dto.DtoAccountIU;

public interface IRestAccountController {

    public RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU);
}
