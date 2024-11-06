package com.p2eb.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p2eb.backend.dto.LoginRequest;
import com.p2eb.backend.service.UserService;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        boolean isAuthenticated = userService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());

        if (isAuthenticated) {
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.APPLICATION_JSON) // Updated to remove deprecated type
                    .body("{\"message\": \"Амжилттай нэвтэрлээ\"}");
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .contentType(MediaType.APPLICATION_JSON) // Updated to remove deprecated type
                    .body("{\"message\": \"Нэвтрэх нэр эсвэл нууц үг буруу байна\"}");
        }
    }
}
