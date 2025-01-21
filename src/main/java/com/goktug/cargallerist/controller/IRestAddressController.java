package com.goktug.cargallerist.controller;

import com.goktug.cargallerist.dto.DtoAddress;
import com.goktug.cargallerist.dto.DtoAddressIU;

public interface IRestAddressController  {

    public RootEntity<DtoAddress> saveAddress(DtoAddressIU dtoAddressIU);
}
