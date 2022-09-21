package com.conversate.demoApp.controller;

import com.conversate.demoApp.entity.User;
import com.conversate.demoApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
       userService.addUser(user);
    }

    @PutMapping("/users/{id}")
        public User updateUser(@RequestBody User user, @PathVariable Long id) {

        return userService.updateUser(id, user);
    }

    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}