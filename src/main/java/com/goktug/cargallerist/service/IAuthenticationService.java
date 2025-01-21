package com.goktug.cargallerist.service;

import com.goktug.cargallerist.dto.AuthRequest;
import com.goktug.cargallerist.dto.AuthResponse;
import com.goktug.cargallerist.dto.DtoUser;
import com.goktug.cargallerist.dto.RefreshTokenRequest;
import org.springframework.stereotype.Service;

@Service
public interface IAuthenticationService {

    public DtoUser register(AuthRequest input);

    public AuthResponse authenticate(AuthRequest input);

    public AuthResponse refreshToken(RefreshTokenRequest input);
}
