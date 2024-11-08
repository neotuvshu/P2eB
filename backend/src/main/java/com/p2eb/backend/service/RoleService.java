package com.p2eb.backend.service;

import com.p2eb.backend.dto.RoleRequest;
import com.p2eb.backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public ResponseEntity<?> assignRole(RoleRequest roleRequest) {
        // Үүрэг оноох логик нэмнэ
        return ResponseEntity.ok().body("Үүрэг амжилттай оноогдлоо.");
    }

    public ResponseEntity<?> updateRole(Long id, RoleRequest roleRequest) {
        // Үүрэг шинэчлэх логик нэмнэ
        return ResponseEntity.ok().body("Үүрэг амжилттай шинэчлэгдлээ.");
    }

    // Үүрэг устгах метод
    public ResponseEntity<?> deleteRole(Long id) {
        // Тухайн ID-тэй үүрэг байгаа эсэхийг шалгана
        if (!roleRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Үүрэг олдсонгүй");
        }
        // Үүргийг устгана
        roleRepository.deleteById(id);
        return ResponseEntity.ok().body("Үүрэг амжилттай устгагдлаа.");
    }
}
