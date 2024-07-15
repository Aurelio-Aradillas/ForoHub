package com.foro.hub.foroHub.controller;

import com.foro.hub.foroHub.domain.user.DataAuthenticationUser;
import com.foro.hub.foroHub.domain.user.User;
import com.foro.hub.foroHub.infra.security.DatosJWTToken;
import com.foro.hub.foroHub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DataAuthenticationUser dataAuthenticationUser) {
        Authentication token = new UsernamePasswordAuthenticationToken(dataAuthenticationUser.email(),
                dataAuthenticationUser.password());
        var userAuth = authenticationManager.authenticate(token);
        var JWTToken = tokenService.generarToken((User) userAuth.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTToken));
    }

}
