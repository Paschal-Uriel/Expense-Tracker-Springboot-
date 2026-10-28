package com.example.Expense_Tracker.service;

import com.example.Expense_Tracker.model.Expense;
import com.example.Expense_Tracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public Expense addExpense(Expense expense) {
        return repository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    public List<Expense> getExpensesByCategory(String category) {
        return repository.findByCategoryIgnoreCase(category);
    }

    public void deleteExpense(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException(
                    "Expense not found with ID: " + id);
        }

        repository.deleteById(id);
    }
}