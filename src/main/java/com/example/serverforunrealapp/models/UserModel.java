package com.example.serverforunrealapp.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_app")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "p_name")
    private String name;

    @Column(name = "p_lastname")
    private String lastName;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "url")
    private String url;
}