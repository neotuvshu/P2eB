package com.p2eb.backend.controller;

import com.p2eb.backend.dto.RoleRequest;
import com.p2eb.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<?> assignRole(@RequestBody RoleRequest roleRequest) {
        return roleService.assignRole(roleRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRole(@PathVariable Long id, @RequestBody RoleRequest roleRequest) {
        return roleService.updateRole(id, roleRequest);
    }

    // Үүрэг устгах метод
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable Long id) {
        return roleService.deleteRole(id);
    }
}
