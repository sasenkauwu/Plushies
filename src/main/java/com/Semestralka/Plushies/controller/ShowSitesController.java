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

    @GetMapping("/adminInterface")
    public String showaAdminInterface() {
        return "adminInterface";
    }

    @GetMapping("/profile")
    public String showProfile() {
        return "profile";
    }

    @GetMapping("/home")
    public String showHome() {
        return "home";
    }

    @GetMapping("/aboutUs")
    public String showAboutUs() {
        return "aboutUs";
    }

    @GetMapping("/products")
    public String showproducts() {
        return "products";
    }

    @GetMapping("/contacts")
    public String showContacts() {
        return "contacts";
    }

    @GetMapping("/returnPolicy")
    public String showReturnPolicy() {
        return "returnPolicy";
    }

    @GetMapping("/privacyPolicy")
    public String showPrivacyPolicy() {
        return "privacyPolicy";
    }

    @GetMapping("/cart")
    public String showCart() {
        return "cart";
    }

}
