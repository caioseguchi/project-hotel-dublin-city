package com.springmvcapp.controller;

import com.springmvcapp.model.UserModel;
import com.springmvcapp.repository.UserRepository;
import com.springmvcapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/hotel-dublin-city")
public class AdminController {
    private final UserService userService;

    @GetMapping("/admin")
    public String adminPage(Model model) {
        List<UserModel> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "admin";
    }


}
