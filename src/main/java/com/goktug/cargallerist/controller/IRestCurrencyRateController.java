package com.goktug.cargallerist.controller;

import com.goktug.cargallerist.dto.CurrencyRateResponse;

public interface IRestCurrencyRateController {

    RootEntity<CurrencyRateResponse> getCurrencyRates(String startDate,String endDate);
}
