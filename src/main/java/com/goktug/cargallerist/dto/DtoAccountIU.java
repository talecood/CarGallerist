package com.goktug.cargallerist.dto;

import com.goktug.cargallerist.enums.CurrencyType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DtoAccountIU {

    @NotNull
    private String accountNo;

    @NotNull
    private String iban;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private CurrencyType currencyType;

    public @NotNull String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(@NotNull String accountNo) {
        this.accountNo = accountNo;
    }

    public @NotNull String getIban() {
        return iban;
    }

    public void setIban(@NotNull String iban) {
        this.iban = iban;
    }

    public @NotNull BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(@NotNull BigDecimal amount) {
        this.amount = amount;
    }

    public @NotNull CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(@NotNull CurrencyType currencyType) {
        this.currencyType = currencyType;
    }
}
