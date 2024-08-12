package com.example.fit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fit.model.User;
import com.example.fit.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) throws Exception {
        // Check if the email already exists in the database
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new Exception("Email already in use");
        }

        // Save the user to the database
        userRepository.save(user);
    }

    public User validateUser(String username, String password) throws Exception {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            user = userRepository.findByEmail(username);
        }

        if (user == null || !user.getPassword().equals(password)) {
            throw new Exception("Invalid credentials");
        }

        return user;
    }
}
