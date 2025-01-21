package com.goktug.cargallerist.controller.impl;

import com.goktug.cargallerist.controller.IRestCurrencyRateController;
import com.goktug.cargallerist.controller.RestBaseController;
import com.goktug.cargallerist.controller.RootEntity;
import com.goktug.cargallerist.dto.CurrencyRateResponse;
import com.goktug.cargallerist.service.ICurrencyRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/api")
public class RestCurrencyRateControllerImpl extends RestBaseController implements IRestCurrencyRateController {

    @Autowired
    private ICurrencyRateService currencyRateService;

    @GetMapping(value = "/currency-rate")
    @Override
    public RootEntity<CurrencyRateResponse> getCurrencyRates(@RequestParam String startDate, @RequestParam String endDate) {
        return ok(currencyRateService.getCurrencyRates(startDate,endDate));
    }
}
