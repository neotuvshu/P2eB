package com.p2eb.backend.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}
