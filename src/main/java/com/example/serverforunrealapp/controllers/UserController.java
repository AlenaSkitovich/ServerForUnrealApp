package com.example.serverforunrealapp.controllers;

import com.example.serverforunrealapp.models.ExpenseModel;
import com.example.serverforunrealapp.models.UserModel;
import com.example.serverforunrealapp.repos.UserRepo;
import com.example.serverforunrealapp.servises.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepo userRepo;

    private final UserService userService;

    public UserController(UserRepo userRepo, UserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    }

    @PostMapping("/register")
    public long register(@RequestParam String login,
                         @RequestParam String password,
                         @RequestParam String name,
                         @RequestParam String lastName,
                         @RequestParam String url) {
        return userService.register(login, password, name, lastName, url);
    }

    @PostMapping("/login")
    public String login(@RequestParam String login,
                        @RequestParam String password) {
        return userService.login(login, password);
    }

    @PostMapping("/editName")
    public void editName(String name, String login) {
        userService.editName(name,login);
    }

    @PostMapping("/editLastName")
    public void editLastName(String lastName, String login) {
        userService.editName(lastName,login);
    }
    @PostMapping("/editPhoto")
    public void editPhoto(String url, String login) {
        userService.editPhoto(url,login);
    }

    @GetMapping("/get")
    public String getUser() {
        return userRepo.findAll().toString();
    }
}
