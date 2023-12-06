package com.Semestralka.Plushies.controller;

import com.Semestralka.Plushies.request.UserRegistrationSaveRequest;
import com.Semestralka.Plushies.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

@RequiredArgsConstructor
public class UserRegistrationController {
    private final UserService userService;

    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "registration";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}
