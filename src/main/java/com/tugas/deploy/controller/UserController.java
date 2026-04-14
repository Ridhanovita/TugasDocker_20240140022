package com.tugas.deploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final String USERNAME = "Ridha";
    private final String PASSWORD = "20240140022";

    @GetMapping("/")
    public String loginPage() {return "login";}

    @PostMapping("/login")
    public String loginPage(@RequestParam String username, @RequestParam String password, Model model) {
        if ((username.equals(USERNAME)) && password.equals(PASSWORD)){
            return "home";
        } else {
            model.addAttribute("Error","Username atau password salah");
        }
        return "login";
    }
}
