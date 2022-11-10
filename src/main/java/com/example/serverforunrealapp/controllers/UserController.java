package com.example.serverforunrealapp.controllers;

import com.example.serverforunrealapp.models.UserModel;
import com.example.serverforunrealapp.repos.UserRepo;
import com.example.serverforunrealapp.servises.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public boolean register(@RequestParam String login,
                            @RequestParam String password,
                            @RequestParam String name,
                            @RequestParam String lastName) {
        return userService.register(login, password, name, lastName);
    }

    @PostMapping
    public String login(@RequestParam String login,
                        @RequestParam String password) {
        return userService.login(login, password);
    }
}
