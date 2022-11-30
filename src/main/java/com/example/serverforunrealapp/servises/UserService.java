package com.example.serverforunrealapp.servises;

import com.example.serverforunrealapp.repos.UserRepo;
import com.example.serverforunrealapp.models.UserModel;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public long register(String login, String password,
                         String name, String lastName, String url
    ) {
        List<String> logins = userRepo.findLogins();
        if (logins.contains(login)) {
            return 0;
        }
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setLastName(lastName);
        userModel.setPassword(password);
        userModel.setLogin(login);
        userModel.setUrl(url);
        userRepo.save(userModel);
        return userRepo.findUserModelByLogin(login).getId();
    }

    public String login(String login, String password) {
        UserModel userModel = userRepo.findUserModelByLogin(login);
        if (userModel == null) {
            return "no user";
        } else if (userModel.getPassword().equals(password)) {
            Gson gson = new Gson();
            return gson.toJson(userModel);
        }
        return "not correct password";
    }

    public void editName(String name, String login) {
        UserModel userModel = userRepo.findUserModelByLogin(login);
        userModel.setName(name);
        userRepo.save(userModel);
    }

    public void editLastName(String lastName, String login) {
        UserModel userModel = userRepo.findUserModelByLogin(login);
        userModel.setLastName(lastName);
        userRepo.save(userModel);
    }

    public void editPhoto(String url, String login) {
        UserModel userModel = userRepo.findUserModelByLogin(login);
        userModel.setUrl(url);
        userRepo.save(userModel);
    }
}
