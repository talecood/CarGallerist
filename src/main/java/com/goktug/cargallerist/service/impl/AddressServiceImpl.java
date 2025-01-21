package com.goktug.cargallerist.service.impl;

import com.goktug.cargallerist.dto.DtoAddress;
import com.goktug.cargallerist.dto.DtoAddressIU;
import com.goktug.cargallerist.model.Address;
import com.goktug.cargallerist.repository.AddressRepository;
import com.goktug.cargallerist.service.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    private Address createAddress(DtoAddressIU dtoAddressIU){
        Address address = new Address();

        address.setCreateTime(new Date());
        BeanUtils.copyProperties(dtoAddressIU,address);

        return address;
    }

    @Override
    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU) {
        Address savedAddress = addressRepository.save(createAddress(dtoAddressIU));

        DtoAddress dtoAddress = new DtoAddress();

        BeanUtils.copyProperties(savedAddress,dtoAddress);
        return dtoAddress;
    }
}
