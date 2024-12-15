package com.springmvcapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

    @GetMapping("/map")
    public String getMapPage() {
        return "map"; // Thymeleaf will render map.html
    }
}