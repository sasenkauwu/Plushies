package com.Semestralka.Plushies.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

@RequiredArgsConstructor
public class ShowSitesController {

    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "registration";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/getUpdateDelete")
    public String showGetUpdateDelete() {
        return "getUpdateDelete";
    }
}
