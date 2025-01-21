package com.goktug.cargallerist.service.impl;

import com.goktug.cargallerist.dto.*;
import com.goktug.cargallerist.enums.CarStatusType;
import com.goktug.cargallerist.exception.BaseException;
import com.goktug.cargallerist.exception.ErrorMessage;
import com.goktug.cargallerist.exception.MessageType;
import com.goktug.cargallerist.model.Car;
import com.goktug.cargallerist.model.Customer;
import com.goktug.cargallerist.model.Gallerist;
import com.goktug.cargallerist.model.SaledCar;
import com.goktug.cargallerist.repository.CarRepository;
import com.goktug.cargallerist.repository.CustomerRepository;
import com.goktug.cargallerist.repository.GalleristRepository;
import com.goktug.cargallerist.repository.SaledCarRepository;
import com.goktug.cargallerist.service.ICurrencyRateService;
import com.goktug.cargallerist.service.ISaledCarService;
import com.goktug.cargallerist.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Optional;

@Service
public class SaledCarServiceImpl implements ISaledCarService {

    @Autowired
    private SaledCarRepository saledCarRepository;
    @Autowired
    private ICurrencyRateService currencyRateService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private GalleristRepository galleristRepository;
    @Autowired
    private CarRepository carRepository;



    private boolean checkAmount(DtoSaledCarIU dtoSaledCarIU){
       Optional<Customer> optionalCustomer = customerRepository.findById(dtoSaledCarIU.getCustomerId());
       if(optionalCustomer.isEmpty()){
           throw new BaseException(new ErrorMessage
                   (MessageType.NO_RECORD_EXIST.getMessage(), MessageType.valueOf(dtoSaledCarIU.getCustomerId().toString())));
       }
       Optional<Car> optionalCar = carRepository.findById(dtoSaledCarIU.getCarId());
        if(optionalCar.isEmpty()){
            throw new BaseException(new ErrorMessage
                    (MessageType.NO_RECORD_EXIST.getMessage(), MessageType.valueOf(dtoSaledCarIU.getCarId().toString())));
        }

        Optional<Gallerist> optionalGallerist = galleristRepository.findById(dtoSaledCarIU.getGalleristId());
        if(optionalGallerist.isEmpty()){
            throw new BaseException(new ErrorMessage
                    (MessageType.NO_RECORD_EXIST.getMessage(), MessageType.valueOf(dtoSaledCarIU.getGalleristId().toString())));
        }


       BigDecimal custUSDamount = convertCustomerAmountToUsd(optionalCustomer.get());


        if((custUSDamount.compareTo(optionalCar.get().getPrice())==0) || (custUSDamount.compareTo(optionalCar.get().getPrice())>0)){
            return true;
        }
        else return false;



    }

    private BigDecimal convertCustomerAmountToUsd(Customer customer){
       CurrencyRateResponse currencyRateResponse =
               currencyRateService.getCurrencyRates(DateUtils.getCurrentDate(new Date()),DateUtils.getCurrentDate(new Date()));

       BigDecimal usd = new BigDecimal(currencyRateResponse.getItems().get(0).getUsd());

      BigDecimal customerUsdAmount = customer.getAccount().getAmount().divide(usd,2, RoundingMode.HALF_UP);

      return customerUsdAmount;

    }

    public boolean checkCarStatus(Long carId){
        Optional<Car> optionalCar =carRepository.findById(carId);
        if(!optionalCar.isPresent() && optionalCar.get().getCarStatusType().name().equals(CarStatusType.SALED)){
            return false;
        }
        return true;
    }

    @Override
    public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU) {

     if(!checkCarStatus(dtoSaledCarIU.getCarId())){
         throw new BaseException
                 (new ErrorMessage(dtoSaledCarIU.getCarId().toString(), MessageType.CAR_STATUS_IS_SALED));
     }
    if(!checkAmount(dtoSaledCarIU)) {
        throw new BaseException
                (new ErrorMessage(dtoSaledCarIU.getCustomerId().toString(), MessageType.CUSTOMER_AMOUNT_IS_NOT_ENOUGH));
    }

    SaledCar savedSaledCar = saledCarRepository.save(createSaledCar(dtoSaledCarIU));

    Car car = savedSaledCar.getCar();
    car.setCarStatusType(CarStatusType.SALED);
    carRepository.save(car);

    Customer customer = savedSaledCar.getCustomer();
    customer.getAccount().setAmount(remainingCustomerAmount(customer,car));
    customerRepository.save(customer);

        return toDto(savedSaledCar);
    }

    public DtoSaledCar toDto(SaledCar saledCar){
        DtoSaledCar dtoSaledCar = new DtoSaledCar();
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoGallerist dtoGallerist = new DtoGallerist();
        DtoCar dtoCar = new DtoCar();

        BeanUtils.copyProperties(saledCar,dtoSaledCar);
        BeanUtils.copyProperties(saledCar.getCustomer(),dtoCustomer);
        BeanUtils.copyProperties(saledCar.getGallerist(),dtoGallerist);
        BeanUtils.copyProperties(saledCar.getCar(),dtoCar);

        dtoSaledCar.setCustomer(dtoCustomer);
        dtoSaledCar.setGallerist(dtoGallerist);
        dtoSaledCar.setCar(dtoCar);

        return dtoSaledCar;
    }

    public BigDecimal remainingCustomerAmount(Customer customer,Car car){
        BigDecimal customerUsdAmount = convertCustomerAmountToUsd (customer);
        BigDecimal remaining = customerUsdAmount.subtract(car.getPrice());

       CurrencyRateResponse currencyRateResponse =
               currencyRateService.getCurrencyRates(DateUtils.getCurrentDate(new Date()),null);

       BigDecimal usd = new BigDecimal(currencyRateResponse.getItems().get(0).getUsd());

       return remaining.multiply(usd);

    }


    private SaledCar createSaledCar(DtoSaledCarIU dtoSaledCarIU){
        SaledCar saledCar = new SaledCar();
        saledCar.setCreateTime(new Date());

        saledCar.setCustomer(customerRepository.findById(dtoSaledCarIU.getCustomerId()).orElse(null));
        saledCar.setGallerist(galleristRepository.findById(dtoSaledCarIU.getGalleristId()).orElse(null));
        saledCar.setCar(carRepository.findById(dtoSaledCarIU.getCarId()).orElse(null));

       return saledCar;
    }
}
