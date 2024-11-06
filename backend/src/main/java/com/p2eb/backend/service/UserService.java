package com.p2eb.backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.p2eb.backend.model.User;
import com.p2eb.backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public boolean authenticateUser(String username, String password) {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        //Хэрэв хэрэглэгч олдвол, нууц үг шалгах
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return  user.getPassword().equals(password);
        }

        return false;
    }
}