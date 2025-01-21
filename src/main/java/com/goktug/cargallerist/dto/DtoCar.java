package com.goktug.cargallerist.dto;

import com.goktug.cargallerist.enums.CarStatusType;
import com.goktug.cargallerist.enums.CurrencyType;

import java.math.BigDecimal;

public class DtoCar extends DtoBase{

    private String plaka;

    private String brand;

    private String model;

    private Integer productionYear;

    private BigDecimal price;

    private CurrencyType currencyType;

    private BigDecimal damagePrice;

    private CarStatusType carStatusType;

}
