package com.goktug.cargallerist.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DtoGallerist extends DtoBase{

    private String firstName;

    private String lastName;

    private DtoAddress dtoAddress;

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

    public DtoAddress getDtoAddress() {
        return dtoAddress;
    }

    public void setDtoAddress(DtoAddress dtoAddress) {
        this.dtoAddress = dtoAddress;
    }
}
