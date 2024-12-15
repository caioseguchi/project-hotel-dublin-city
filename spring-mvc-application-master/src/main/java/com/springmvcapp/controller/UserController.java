package com.springmvcapp.controller;

import com.springmvcapp.model.UserModel;
import com.springmvcapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }


    @GetMapping("/register")
    public String getRegistrationPage(Model model) {
        model.addAttribute("user", new UserModel());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserModel user) {
        userService.register(user);
        return "redirect:/login?success";
    }

    @GetMapping("/client")
    public String clientPage() {
        return "client"; // Template para cliente
    }


    @GetMapping("/client-tripadvaisor")
    public String tripPage() {
        return "client-tripadvaisor";
    }
    @GetMapping("/facilities")
    public String facilitiesPage() {
        return "facilities";
    }
}
