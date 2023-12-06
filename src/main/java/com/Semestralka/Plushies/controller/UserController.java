package com.Semestralka.Plushies.controller;

import com.Semestralka.Plushies.entity.User;
import com.Semestralka.Plushies.request.UserRegistrationSaveRequest;
import com.Semestralka.Plushies.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable UUID id) {
        return userService.getUser(id);
    }

    @PostMapping("/save")
    public void saveUser(@RequestBody UserRegistrationSaveRequest request) {
        userService.registerUser(request);
    }

    @PostMapping("/registerUser")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationSaveRequest saveRequest) {
        userService.registerUser(saveRequest);
        return ResponseEntity.ok("User registered successfully");
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
    }

    @PutMapping("update/{id}")
    public void updateUser(@PathVariable UUID id) {
        userService.updateUser(id);
    }
}

