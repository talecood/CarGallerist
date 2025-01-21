package com.goktug.cargallerist.service;

import com.goktug.cargallerist.dto.DtoAddress;
import com.goktug.cargallerist.dto.DtoAddressIU;

public interface IAddressService {

    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU);

}
