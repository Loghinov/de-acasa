package org.deacasa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserAuthenticationController {

    // Страница входа
    @GetMapping("/login")
    public String login() {
        return "login";  // Отображаем страницу входа для неаутентифицированного пользователя
    }

    // Страница регистрации
    @GetMapping("/register")
    public String register() {
        return "register";  // Отображаем страницу регистрации для неаутентифицированного пользователя
    }
}
