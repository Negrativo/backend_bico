package com.backend_bico.bico.controller;

import com.backend_bico.bico.model.login.DbAuthCredentials;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private static final String NAO_AUTENTICADO = "USUÁRIO NÃO AUTENTICADO.";
    private final AuthenticationManager authenticationManager;

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public void doLogin(DbAuthCredentials credentials) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getSenha())
            );
            if (authentication.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                throw new BadCredentialsException(NAO_AUTENTICADO);
            }
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(NAO_AUTENTICADO);
        }
    }

}
