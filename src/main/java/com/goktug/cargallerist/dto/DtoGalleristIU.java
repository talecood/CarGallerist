package com.goktug.cargallerist.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoGalleristIU {

    private String firstName;


    private String lastName;


    private Long addressId;

    public DtoGalleristIU(String firstName, String lastName, Long addressId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressId = addressId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
