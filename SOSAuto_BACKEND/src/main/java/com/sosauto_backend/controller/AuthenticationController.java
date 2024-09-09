package com.sosauto_backend.controller;


import com.sosauto_backend.model.Dto.PersonneDTO;
import com.sosauto_backend.model.Entity.AuthResponse;
import com.sosauto_backend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.sosauto_backend.controller.utils.Constants.APP_PERMIT_ALL;


@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(APP_PERMIT_ALL +"/login")
    public ResponseEntity<AuthResponse> login(@RequestBody PersonneDTO request) {
            return ResponseEntity.ok(authenticationService.authenticate(request));


    }


}





