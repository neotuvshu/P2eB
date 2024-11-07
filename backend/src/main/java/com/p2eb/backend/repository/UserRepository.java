// UserRepository.java
package com.p2eb.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.p2eb.backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}