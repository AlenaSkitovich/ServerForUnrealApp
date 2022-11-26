package com.example.serverforunrealapp.controllers;

import com.example.serverforunrealapp.models.ExpenseModel;
import com.example.serverforunrealapp.repos.ExpenseRepo;
import com.example.serverforunrealapp.servises.ExpenseService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseRepo expenseRepo;

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseRepo expenseRepo, ExpenseService expenseService) {
        this.expenseRepo = expenseRepo;
        this.expenseService = expenseService;
    }

    @PostMapping("/add")
    public boolean addExpense(@RequestParam double sum,
                              @RequestParam String name,
                              @RequestParam long time,
                              @RequestParam int day,
                              @RequestParam int month,
                              @RequestParam int year,
                              @RequestParam String login) {
        return expenseService.addExpense(sum, name, time, day, month, year, login);
    }

    @PostMapping("/delete")
    public void delete(@RequestParam long id) {
        expenseService.delete(id);
    }

    @PostMapping("/edit")
    public void edit(@RequestParam double sum,
                     @RequestParam long id, @RequestParam String name) {
        expenseService.edit(sum, id, name);
    }

    @PostMapping("/getMonthlyAmounts")
    public String getSumByMonth(@RequestParam int month,
                                @RequestParam long id) {
        return expenseService.getSumByMonth(month, id);
    }

    @PostMapping("/getAnnualAmounts")
    public String getSumByYear(@RequestParam int year,
                               @RequestParam long id) {
        return expenseService.getSumByYear(year, id);
    }

    @GetMapping("/getById/{userId}")
    public List<ExpenseModel> getAll() {
        return expenseRepo.findAll();
    }
}
