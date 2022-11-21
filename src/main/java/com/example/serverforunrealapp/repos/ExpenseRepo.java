package com.example.serverforunrealapp.repos;

import com.example.serverforunrealapp.models.ExpenseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ExpenseRepo extends JpaRepository<ExpenseModel, Long> {

    ExpenseModel getExpenseModelById(long id);

    @Transactional
    void deleteById(long id);

    @Modifying
    @Query(value = "select e from ExpenseModel e where e.userModel.id=:id and e.month like :month",
            nativeQuery = true)
    List<ExpenseModel> findSumByMonth(int month, long id);

    @Modifying
    @Query(value = "select e from ExpenseModel e where e.userModel.id=:id and e.year like :year",
            nativeQuery = true)
    List<ExpenseModel> findSumByYear(int year, long id);

}
