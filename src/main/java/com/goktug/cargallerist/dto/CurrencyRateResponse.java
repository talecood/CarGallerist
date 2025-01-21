package com.goktug.cargallerist.dto;

import java.util.List;

public class CurrencyRateResponse {

    int totalCount;

    private List<CurrencyRateItems> items;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<CurrencyRateItems> getItems() {
        return items;
    }

    public void setItems(List<CurrencyRateItems> items) {
        this.items = items;
    }
}
