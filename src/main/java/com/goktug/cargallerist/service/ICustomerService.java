package com.goktug.cargallerist.service;

import com.goktug.cargallerist.dto.DtoCustomer;
import com.goktug.cargallerist.dto.DtoCustomerIU;
import org.springframework.stereotype.Service;

public interface ICustomerService {

    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);
}
