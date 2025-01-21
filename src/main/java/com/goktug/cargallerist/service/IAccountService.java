package com.goktug.cargallerist.service;

import com.goktug.cargallerist.dto.DtoAccount;
import com.goktug.cargallerist.dto.DtoAccountIU;

public interface IAccountService {

    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);
}
