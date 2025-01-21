package com.goktug.cargallerist.service.impl;

import com.goktug.cargallerist.dto.DtoAccount;
import com.goktug.cargallerist.dto.DtoAddress;
import com.goktug.cargallerist.dto.DtoCustomer;
import com.goktug.cargallerist.dto.DtoCustomerIU;
import com.goktug.cargallerist.exception.BaseException;
import com.goktug.cargallerist.exception.ErrorMessage;
import com.goktug.cargallerist.exception.MessageType;
import com.goktug.cargallerist.handler.Exception;
import com.goktug.cargallerist.model.Account;
import com.goktug.cargallerist.model.Address;
import com.goktug.cargallerist.model.Customer;
import com.goktug.cargallerist.repository.AccountRepository;
import com.goktug.cargallerist.repository.AddressRepository;
import com.goktug.cargallerist.repository.CustomerRepository;
import com.goktug.cargallerist.service.ICustomerService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AccountRepository accountRepository;


    private Customer createCustomer(DtoCustomerIU dtoCustomerIU){
        Optional<Address> optionalAddress = addressRepository.findById(dtoCustomerIU.getAddressId());

        if(optionalAddress.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST.getMessage(), dtoCustomerIU.getAddressId()));
        }

        Optional<Account> optionalAccount = accountRepository.findById(dtoCustomerIU.getAccountId());
        if(optionalAccount.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST.getMessage(), dtoCustomerIU.getAddressId()));
        }


        Customer customer = new Customer();
        customer.setCreateTime(new Date());


        BeanUtils.copyProperties(dtoCustomerIU,customer);
        customer.setAddress(optionalAddress.get());
        customer.setAccount(optionalAccount.get());

        return customer;

    }

    @Override
    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {

        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();
        DtoAccount dtoAccount = new DtoAccount();
        Customer savedCustomer = customerRepository.save(createCustomer(dtoCustomerIU));

        BeanUtils.copyProperties(savedCustomer,dtoCustomer);
        BeanUtils.copyProperties(savedCustomer.getAddress(),dtoAddress);
        BeanUtils.copyProperties(savedCustomer.getAccount(),dtoAccount);

        return dtoCustomer;
    }
}
