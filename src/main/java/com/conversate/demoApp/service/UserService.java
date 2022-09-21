package com.conversate.demoApp.service;


import com.conversate.demoApp.entity.User;
import com.conversate.demoApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException());
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setLocation(user.getLocation());
        existingUser.setEmail(user.getEmail());

        userRepository.save(existingUser);
        return existingUser;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
