package com.vrapalis.www.backend.tutorials.security.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityFormHomeController {

    @GetMapping("home")
    public String home() {
        return "home";
    }

    @GetMapping("admin")
    public String admin() {
        return "admin";
    }
}
