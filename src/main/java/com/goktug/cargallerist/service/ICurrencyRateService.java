package com.goktug.cargallerist.service;

import com.goktug.cargallerist.dto.CurrencyRateResponse;

public interface ICurrencyRateService {

    public CurrencyRateResponse getCurrencyRates(String startDate,String endDate);
}
