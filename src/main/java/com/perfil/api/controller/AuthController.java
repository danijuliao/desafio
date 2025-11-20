package com.desafio.api.controller;

import com.desafio.api.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Validação simples (pode integrar com banco depois)
        if ("admin".equals(username) && "1234".equals(password)) {
            return JwtUtil.generateToken(username);
        }
        throw new RuntimeException("Credenciais inválidas");
    }
}