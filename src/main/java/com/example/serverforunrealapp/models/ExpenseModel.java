package com.example.serverforunrealapp.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "expense")
public class ExpenseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "ex_name")
    private String name;

    @Column(name = "sum")
    private double sum;

    @Column(name = "time")
    long time;

    @Column(name = "day")
    private int day;

    @Column(name = "month")
    private int month;

    @Column(name = "year")
    private int year;

    @ManyToOne
    UserModel userModel;
}
