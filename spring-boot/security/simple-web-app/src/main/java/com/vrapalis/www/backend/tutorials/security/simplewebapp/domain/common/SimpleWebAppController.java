package com.vrapalis.www.backend.tutorials.security.simplewebapp.domain.common;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleWebAppController {

    @GetMapping
    public String redirectToHome() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/products")
    public String products(Model model) {
        return "products";
    }

    @GetMapping("/admin-dashboard")
    public String adminDashboard(Authentication authentication, Model model) {
        model.addAttribute("username", authentication.getName());
        return "admin-dashboard";
    }

    @GetMapping("/access-denied")
    public String accessDenied(Authentication authentication, Model model) {
        model.addAttribute("username", authentication.getName());
        return "/access-denied";
    }
}
