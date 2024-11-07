package com.p2eb.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p2eb.backend.jwt.JwtUtil;
import com.p2eb.backend.dto.LoginRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // Нэвтрэх нэр болон нууц үгийг авна
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        // Хэрэглэгчийг баталгаажуулах
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(username, password)
        );

        // Нэвтэрсэн хэрэглэгчийн мэдээллийг авна
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // JWT токен үүсгэх
        return jwtUtil.generateToken(userDetails.getUsername());
    }
}
