package com.goktug.cargallerist.service.impl;

import com.goktug.cargallerist.dto.DtoAddress;
import com.goktug.cargallerist.dto.DtoGallerist;
import com.goktug.cargallerist.dto.DtoGalleristIU;
import com.goktug.cargallerist.exception.BaseException;
import com.goktug.cargallerist.exception.ErrorMessage;
import com.goktug.cargallerist.exception.MessageType;
import com.goktug.cargallerist.model.Address;
import com.goktug.cargallerist.model.Gallerist;
import com.goktug.cargallerist.repository.AddressRepository;
import com.goktug.cargallerist.repository.GalleristRepository;
import com.goktug.cargallerist.service.IGalleristService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GalleristServiceImpl implements IGalleristService {

    @Autowired
    private GalleristRepository galleristRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU) {
        DtoGallerist dtoGallerist = new DtoGallerist();
        DtoAddress dtoAddress = new DtoAddress();

        Gallerist savedGallerist = galleristRepository.save(createGallerist(dtoGalleristIU));
        BeanUtils.copyProperties(savedGallerist,dtoGallerist);
        BeanUtils.copyProperties(savedGallerist.getAddress(),dtoAddress);

        dtoGallerist.setDtoAddress(dtoAddress);

        return dtoGallerist;
    }

    private Gallerist createGallerist(DtoGalleristIU dtoGalleristIU) {
        Gallerist gallerist = new Gallerist();
        gallerist.setCreateTime(new Date());

        Optional<Address> galleristAddressOptional = addressRepository.findById(dtoGalleristIU.getAddressId());
        if(galleristAddressOptional.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST.getMessage(), dtoGalleristIU.getAddressId()));
        }


        BeanUtils.copyProperties(dtoGalleristIU,gallerist);
        gallerist.setAddress(galleristAddressOptional.get());

        return gallerist;
    }
}
