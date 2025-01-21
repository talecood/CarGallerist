package com.goktug.cargallerist.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DtoCustomer extends DtoBase{

    private String first_name;

    private String last_name;

    private String tckn;

    private Date birthOfDate;

    private DtoAddress address;

    private DtoAccount account;
}
