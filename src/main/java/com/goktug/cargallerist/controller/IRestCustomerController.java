package com.goktug.cargallerist.controller;

import com.goktug.cargallerist.dto.DtoCustomer;
import com.goktug.cargallerist.dto.DtoCustomerIU;

public interface IRestCustomerController {
    RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);
}
