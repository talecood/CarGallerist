package com.goktug.cargallerist.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    public @NotEmpty String getUsername() {
        return username;
    }

    public void setUsername(@NotEmpty String username) {
        this.username = username;
    }

    public @NotEmpty String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty String password) {
        this.password = password;
    }
}
