package com.goktug.cargallerist.controller;

import com.goktug.cargallerist.dto.AuthRequest;
import com.goktug.cargallerist.dto.AuthResponse;
import com.goktug.cargallerist.dto.DtoUser;
import com.goktug.cargallerist.dto.RefreshTokenRequest;
import com.goktug.cargallerist.model.RefreshToken;

public interface IRestAuthenticationController {

   public RootEntity<DtoUser> register(AuthRequest request);

   public RootEntity<AuthResponse> authenticate(AuthRequest request);

   public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest input);
}
