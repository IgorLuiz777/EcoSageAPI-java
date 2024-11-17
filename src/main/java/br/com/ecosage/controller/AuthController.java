package br.com.ecosage.controller;

import br.com.ecosage.model.dto.Credentials;
import br.com.ecosage.model.dto.Token;
import br.com.ecosage.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public Token login (@RequestBody Credentials credentials){
        return authService.login(credentials);
    }
}
