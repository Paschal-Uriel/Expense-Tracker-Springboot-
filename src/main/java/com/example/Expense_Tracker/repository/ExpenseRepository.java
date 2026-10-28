package com.example.Expense_Tracker.repository;

import com.example.Expense_Tracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository
        extends JpaRepository<Expense, Long> {

    List<Expense> findByCategoryIgnoreCase(String category);
}