package com.goktug.cargallerist.service.impl;

import com.goktug.cargallerist.dto.CurrencyRateResponse;
import com.goktug.cargallerist.exception.BaseException;
import com.goktug.cargallerist.exception.ErrorMessage;
import com.goktug.cargallerist.exception.MessageType;
import com.goktug.cargallerist.service.ICurrencyRateService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyRateServiceImpl implements ICurrencyRateService {

    @Override
    public CurrencyRateResponse getCurrencyRates(String startDate, String endDate) {
        String rootURL = "https://evds2.tcmb.gov.tr/service/evds/";
        String series = "TP.DK.USD.A";
        String type = "json";

        String endpoint = rootURL + "series=" + series + "&startDate=" + startDate + "&endDate=" + endDate + "&type="
                + type;

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("key", "XsBxAxzaVo");

        HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);

        try {
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<CurrencyRateResponse> response = restTemplate.exchange(endpoint, HttpMethod.GET, httpEntity,
                    new ParameterizedTypeReference<CurrencyRateResponse>() {
                    });
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            }
        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(e.getMessage(), MessageType.CURRENY_RATES_IS_OCCURED));
        }
        return null;

    }
}
