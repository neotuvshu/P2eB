package com.p2eb.backend.dto;

public class LoginRequest {
    private String username;
    private String password;

    // Нэвтрэх нэрийг авах арга
    public String getUsername() {
        return username;
    }

    // Нууц үгийг авах арга
    public String getPassword() {
        return password;
    }

    // Setter-үүд шаардлагатай бол
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
