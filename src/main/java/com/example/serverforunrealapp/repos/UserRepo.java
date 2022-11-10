package com.example.serverforunrealapp.repos;

import com.example.serverforunrealapp.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<UserModel, Long> {
    UserModel findUserModelByLogin(String login);
    @Query(value = "select login from user_app", nativeQuery = true)
    List<String> findLogins();
}
