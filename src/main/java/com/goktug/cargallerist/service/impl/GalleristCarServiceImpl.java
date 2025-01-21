package com.goktug.cargallerist.service.impl;

import com.goktug.cargallerist.dto.*;
import com.goktug.cargallerist.exception.BaseException;
import com.goktug.cargallerist.exception.ErrorMessage;
import com.goktug.cargallerist.exception.MessageType;
import com.goktug.cargallerist.model.Car;
import com.goktug.cargallerist.model.Gallerist;
import com.goktug.cargallerist.model.GalleristCar;
import com.goktug.cargallerist.repository.CarRepository;
import com.goktug.cargallerist.repository.GalleristCarRepository;
import com.goktug.cargallerist.repository.GalleristRepository;
import com.goktug.cargallerist.service.IGalleristCarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GalleristCarServiceImpl implements IGalleristCarService {

    @Autowired
    private GalleristRepository galleristRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private GalleristCarRepository galleristCarRepository;

    @Override
    public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU){
        DtoGalleristCar dtoGalleristCar = new DtoGalleristCar();
        DtoGallerist dtoGallerist = new DtoGallerist();
        DtoCar dtoCar = new DtoCar();

        DtoAddress dtoAddress = new DtoAddress();

        GalleristCar savedGalleristCar = galleristCarRepository.save(createNewGalleristCar(dtoGalleristCarIU));

        BeanUtils.copyProperties(savedGalleristCar.getGallerist().getAddress(),dtoAddress);
        BeanUtils.copyProperties(savedGalleristCar,dtoGalleristCar);
        BeanUtils.copyProperties(savedGalleristCar.getGallerist(),dtoGallerist);
        BeanUtils.copyProperties(savedGalleristCar.getCar(),dtoCar);

        dtoGallerist.setDtoAddress(dtoAddress);
        dtoGalleristCar.setDtoGallerist(dtoGallerist);
        dtoGalleristCar.setDtoCar(Optional.of(dtoCar));

        return dtoGalleristCar;
    }

    private GalleristCar createNewGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {
        GalleristCar galleristCar = new GalleristCar();
        galleristCar.setCreateTime(new Date());

        Optional<Gallerist> optionalGallerist = galleristRepository.findById(dtoGalleristCarIU.getGalleristId());
        if(optionalGallerist.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST.getMessage(), MessageType.valueOf(dtoGalleristCarIU.getGalleristId().toString())));
        }
        Optional<Car> optionalCar = carRepository.findById(dtoGalleristCarIU.getCarId());
        if(optionalCar.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST.getMessage(), MessageType.valueOf(dtoGalleristCarIU.getGalleristId().toString())));
        }

        galleristCar.setGallerist(optionalGallerist.get());
        galleristCar.setCar(optionalCar.get());

        return galleristCar;
    }

}
