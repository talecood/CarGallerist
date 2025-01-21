package com.goktug.cargallerist.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoAddressIU {


    @NotEmpty
    private String city;
    @NotEmpty
    private String district;
    @NotEmpty
    private String neighborhood;
    @NotEmpty
    private String street;

    public @NotEmpty String getCity() {
        return city;
    }

    public void setCity(@NotEmpty String city) {
        this.city = city;
    }

    public @NotEmpty String getDistrict() {
        return district;
    }

    public void setDistrict(@NotEmpty String district) {
        this.district = district;
    }

    public @NotEmpty String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(@NotEmpty String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public @NotEmpty String getStreet() {
        return street;
    }

    public void setStreet(@NotEmpty String street) {
        this.street = street;
    }
}
