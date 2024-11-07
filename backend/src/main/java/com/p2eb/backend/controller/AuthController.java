package com.p2eb.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p2eb.backend.dto.LoginRequest;
import com.p2eb.backend.dto.LoginResponse;
import com.p2eb.backend.service.UserService;
import com.p2eb.backend.util.JwtUtil;

@RestController //
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        boolean isAuthenticated = userService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());

        if (isAuthenticated) {
            String token = JwtUtil.generateToken(loginRequest.getUsername());
            LoginResponse response = new LoginResponse(token, "Амжилттай нэвтэрлээ!");
            return ResponseEntity.ok(response);
        } else {
            LoginResponse response = new LoginResponse(null, "Нэвтрэх нэр эсвэл нууц үг буруу байна");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
