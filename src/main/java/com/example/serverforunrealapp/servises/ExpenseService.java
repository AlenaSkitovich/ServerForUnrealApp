package com.example.serverforunrealapp.servises;

import com.example.serverforunrealapp.models.ExpenseModel;
import com.example.serverforunrealapp.repos.ExpenseRepo;
import com.example.serverforunrealapp.repos.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepo expenseRepo;
    private final UserRepo userRepo;

    public ExpenseService(ExpenseRepo expenseRepo, UserRepo userRepo) {
        this.expenseRepo = expenseRepo;
        this.userRepo = userRepo;
    }

    public boolean addExpense(double sum, long time,
                              int day, int month, int year, String login) {
        ExpenseModel expenseModel = new ExpenseModel();
        expenseModel.setUserModel(userRepo.findUserModelByLogin(login));
        expenseModel.setSum(sum);
        expenseModel.setTime(time);
        expenseModel.setDay(day);
        expenseModel.setMonth(month);
        expenseModel.setYear(year);
        expenseRepo.save(expenseModel);
        return true;
    }


    public void delete(long id) {
        expenseRepo.deleteById(id);
    }

    public void edit(double sum, long id, String name) {
        ExpenseModel expenseModel = expenseRepo.getExpenseModelById(id);
        expenseModel.setSum(sum);
        expenseModel.setName(name);
        expenseRepo.save(expenseModel);
    }


    public String getSumByMonth(int month, long id) {
        try {
            List<ExpenseModel> list1 = expenseRepo.findSumByMonth(month, id);
            return list1.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
    }

    public String getSumByYear(int year, long id) {
        try {
            List<ExpenseModel> list2 = expenseRepo.findSumByYear(year, id);
            return list2.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
    }
}
