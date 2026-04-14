package com.tugas.deploy.controller;

import com.tugas.deploy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private  final List<User> userList = new ArrayList<>();
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

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("users", userList);
        return "home";
    }

    @GetMapping("/form")
    public String formPage(Model model){
        model.addAttribute("user", new User());
        return "home";
    }

    @PostMapping("/form")
    public String formPage(@ModelAttribute User user){
        userList.add(user);
        return "redirect:/home";
    }
}
