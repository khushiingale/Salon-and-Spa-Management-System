package com.salon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("title", "Welcome to Salon Booking");
        return "index"; // This returns index.html from the templates folder
    }
}
