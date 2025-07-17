package org.deacasa.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.deacasa.entity.User;
import org.deacasa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/auth/")
@Tag(name="Auth", description = "Регистрация и авторизация пользователя")
public class AuthController {

    @Autowired
    private UserService userService;

    // Registration Endpoint (API version)
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.registerUser(user);  // Call service to register the user
        return ResponseEntity.ok("User registered successfully");
    }

    // Login Endpoint (for API or custom login logic)
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        // Your custom login logic here (might use Spring Security or custom)
        String token=userService.verifyUser(user);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/token-verify-home")
    public ResponseEntity<String> redirectUserHome(HttpServletResponse response) throws IOException {
        response.sendRedirect("/home.html"); // Redirect to home page
        return ResponseEntity.ok().build();
    }
}