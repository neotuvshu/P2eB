package com.p2eb.backend.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.p2eb.backend.dto.UpdateUserRequest;
import com.p2eb.backend.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Хэрэглэгчийн мэдээллийг шинэчлэх метод
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest updateUserRequest) {
        // userService-ийн updateUser() методуудыг дуудаж, үр дүнг буцаана
        return userService.updateUser(id, updateUserRequest);
    }

    // Хэрэглэгчийн мэдээллийг устгах метод
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        // userService-ийн deleteUser() методуудыг дуудаж, үр дүнг буцаана
        return userService.deleteUser(id);
    }
}
