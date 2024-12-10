package com.springmvcapp.service;

import com.springmvcapp.model.UserModel;
import com.springmvcapp.model.UserRole;
import com.springmvcapp.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @PostConstruct
    public void postConstruct() {
        if (userRepository.findByUsername("admin").isEmpty()) {
            UserModel admin = new UserModel();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("abc"));
            admin.setRole(UserRole.ADMIN);
            userRepository.save(admin); // Save admin in the database
        }
    }

    public void register(UserModel user) {
        user.setRole(UserRole.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user); // Save user in the database
    }

    public UserModel findByLogin(String username) {
        return userRepository.findByUsername(username)
                .orElse(null); // Search in the dadabase
    }

    public List<UserModel> findAllUsers() {
        return userRepository.findAll();//return all users
    }


}
