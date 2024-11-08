package com.p2eb.backend.config;

import com.p2eb.backend.model.User;
import com.p2eb.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.annotation.PostConstruct;

@Configuration
public class InitialUserSetup {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // SecurityConfig-т байгаа PasswordEncoder-ийг ашиглана

    @PostConstruct
    public void createDefaultAdmin() {
        if (userRepository.count() == 0) {
            User adminUser = new User();
            adminUser.setUsername("admin");
            adminUser.setPassword(passwordEncoder.encode("1234")); // Нууц үгийг шифрлэнэ
            adminUser.setUserNm("Admin");
            adminUser.setUseYn("Y");
            adminUser.setRole("ADMIN"); // Админ хэрэглэгчийн үүрэг

            userRepository.save(adminUser);
            System.out.println("Анхны админ хэрэглэгч үүсгэгдлээ.");
        }
    }
}