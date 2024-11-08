package com.p2eb.backend.service;

import com.p2eb.backend.dto.UpdateUserRequest;
import com.p2eb.backend.model.User;
import com.p2eb.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> updateUser(Long id, UpdateUserRequest updateUserRequest) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return ResponseEntity.badRequest().body("Хэрэглэгч олдсонгүй");
        }
        existingUser.setRole(updateUserRequest.getRole());
        userRepository.save(existingUser);
        return ResponseEntity.ok().body("Хэрэглэгч амжилттай шинэчлэгдлээ.");
    }

    public ResponseEntity<?> deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Хэрэглэгч олдсонгүй");
        }
        userRepository.deleteById(id);
        return ResponseEntity.ok().body("Хэрэглэгч амжилттай устгагдлаа.");
    }
}
