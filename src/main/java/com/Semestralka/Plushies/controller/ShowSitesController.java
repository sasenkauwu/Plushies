package com.Semestralka.Plushies.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

@RequiredArgsConstructor
public class ShowSitesController {

    @GetMapping("/registration")
    public String showRegistrationForm(Model model, HttpSession session) {
        model.addAttribute("isLoggedIn", session.getAttribute("loggedInUser") != null);
        return "registration";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model, HttpSession session) {
        model.addAttribute("isLoggedIn", session.getAttribute("loggedInUser") != null);
        return "login";
    }

    @GetMapping("/adminInterface")
    public String showaAdminInterface(Model model, HttpSession session) {
        model.addAttribute("isLoggedIn", session.getAttribute("loggedInUser") != null);
        return "adminInterface";
    }

    @GetMapping("/profile")
    public String showProfile(Model model, HttpSession session) {
        model.addAttribute("isLoggedIn", session.getAttribute("loggedInUser") != null);
        return "profile";
    }

    @GetMapping("/home")
    public String showHome(Model model, HttpSession session) {
        model.addAttribute("isLoggedIn", session.getAttribute("loggedInUser") != null);
        return "home";
    }

    @GetMapping("/aboutUs")
    public String showAboutUs(Model model, HttpSession session) {
        model.addAttribute("isLoggedIn", session.getAttribute("loggedInUser") != null);
        return "aboutUs";
    }

    @GetMapping("/products")
    public String showproducts(Model model, HttpSession session) {
        model.addAttribute("isLoggedIn", session.getAttribute("loggedInUser") != null);
        return "products";
    }

    @GetMapping("/contacts")
    public String showContacts(Model model, HttpSession session) {
        model.addAttribute("isLoggedIn", session.getAttribute("loggedInUser") != null);
        return "contacts";
    }

    @GetMapping("/returnPolicy")
    public String showReturnPolicy(Model model, HttpSession session) {
        model.addAttribute("isLoggedIn", session.getAttribute("loggedInUser") != null);
        return "returnPolicy";
    }

    @GetMapping("/privacyPolicy")
    public String showPrivacyPolicy(Model model, HttpSession session) {
        model.addAttribute("isLoggedIn", session.getAttribute("loggedInUser") != null);
        return "privacyPolicy";
    }

    @GetMapping("/cart")
    public String showCart(Model model, HttpSession session) {
        model.addAttribute("isLoggedIn", session.getAttribute("loggedInUser") != null);
        return "cart";
    }

}
