package com.example.serverforunrealapp.servises;

import com.example.serverforunrealapp.repos.UserRepo;
import com.example.serverforunrealapp.models.UserModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public boolean register(String login,String password,
                            String name,String lastName
                            ){
        List<String> logins = userRepo.findLogins();
        if(logins.contains(login)){
            return false;
        }
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setLastName(lastName);
        userModel.setPassword(password);
        userModel.setLogin(login);
        userRepo.save(userModel);
        return true;
    }
    public String login(String login, String password) {
        UserModel userModel = null;
        userModel = userRepo.findUserModelByLogin(login);
        if (userModel == null) {
            return "no user";
        } else if (userModel.getPassword().equals(password)) {
            return userModel.toString();
        }
        return "not correct password";
    }
}
