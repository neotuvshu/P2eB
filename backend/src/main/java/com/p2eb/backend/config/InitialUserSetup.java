package com.p2eb.backend.config;

import com.p2eb.backend.model.User;
import com.p2eb.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import javax.annotation.PostConstruct;

@Configuration
public class InitialUserSetup {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void createDefaultAdmin() {
        if (userRepository.count() == 0) {
            User adminUser = new User();
            adminUser.setUserId("admin");
            adminUser.setUserPwd("1234");
            adminUser.setUserNm("Admin");
            adminUser.setUseYn("Y");
            userRepository.save(adminUser);
            System.out.println("Анхны админ хэрэглэгч үүсгэгдлээ.");
        }
    }
}
