package com.p2eb.backend.dto;

import lombok.Data;

@Data
public class RoleRequest {
    private String roleName;
    private Long userId;
}
