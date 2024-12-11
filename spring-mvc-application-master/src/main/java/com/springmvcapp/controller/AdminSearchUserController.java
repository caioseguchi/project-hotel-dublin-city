package com.springmvcapp.controller;

import com.springmvcapp.model.UserModel;
import com.springmvcapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/hotel-dublin-city")
public class AdminSearchUserController {

    private final UserRepository userRepository;

    @GetMapping("/admin-search-user")
    public String showSearchPage(Model model) {
        model.addAttribute("user", null);
        model.addAttribute("searchPerformed", false);
        return "admin-search-user";
    }

    @GetMapping("/admin-search-user/search")
    public String searchUser(@RequestParam("username") String username, Model model) {
        Optional<UserModel> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent()) {
            model.addAttribute("user", userOptional.get());
        } else {
            model.addAttribute("user", null);
        }
        model.addAttribute("searchPerformed", true);
        return "admin-search-user";
    }
}

