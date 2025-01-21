package com.goktug.cargallerist.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefreshTokenRequest {

    @NotEmpty
    private String refreshToken;

    public @NotEmpty String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(@NotEmpty String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
