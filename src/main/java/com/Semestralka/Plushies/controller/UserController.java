package com.Semestralka.Plushies.controller;

import com.Semestralka.Plushies.entity.User;
import com.Semestralka.Plushies.request.UserLoginRequest;
import com.Semestralka.Plushies.request.UserRegistrationSaveRequest;
import com.Semestralka.Plushies.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/getUser")
    public ResponseEntity<User> getUser(@RequestParam String email) {
        if (userService.getUser(email) != null) {
            return ResponseEntity.ok(userService.getUser(email));
        }
        return ResponseEntity.notFound().build();
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

   /* @PostMapping("/loginUser")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginRequest loginRequest) {
        if (userService.loginUser(loginRequest)) {
            return ResponseEntity.ok("User logged in successfully.");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
    }*/

    @PostMapping("/loginUser")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginRequest loginRequest, HttpSession session) {
        User user = userService.loginUser(loginRequest);
        if (user != null) {
            session.setAttribute("loggedInUser", user);
            return ResponseEntity.ok("User logged in successfully.");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
    }

    @GetMapping("/checkSession")
    public ResponseEntity<User> checkSession(HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("User logged out successfully.");
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

