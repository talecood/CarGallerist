package com.goktug.cargallerist.controller.impl;

import com.goktug.cargallerist.controller.IRestAuthenticationController;
import com.goktug.cargallerist.controller.RestBaseController;
import com.goktug.cargallerist.controller.RootEntity;
import com.goktug.cargallerist.dto.AuthRequest;
import com.goktug.cargallerist.dto.AuthResponse;
import com.goktug.cargallerist.dto.DtoUser;
import com.goktug.cargallerist.dto.RefreshTokenRequest;
import com.goktug.cargallerist.service.IAuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAuthenticationControllerImpl extends RestBaseController implements IRestAuthenticationController {


    @Qualifier("authenticationServiceImpl")
    @Autowired
    private IAuthenticationService authenticationService;

    @PostMapping("/register")
    @Override
    public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest request) {
        return ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    @Override
    public RootEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest request) {
        return ok(authenticationService.authenticate(request));
    }

    @PostMapping("refreshToken")
    @Override
    public RootEntity<AuthResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest input) {
        return ok(authenticationService.refreshToken(input));
    }
}























