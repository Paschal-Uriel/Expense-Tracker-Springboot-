package com.example.Expense_Tracker.controller;

import com.example.Expense_Tracker.model.Expense;
import com.example.Expense_Tracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    // 1. Add an expense
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Expense addExpense(
            @Valid @RequestBody Expense expense) {
        return service.addExpense(expense);
    }

    // 2. View all expenses
    @GetMapping
    public List<Expense> getAllExpenses() {
        return service.getAllExpenses();
    }

    // 3. View expenses by category
    @GetMapping("/category/{category}")
    public List<Expense> getExpensesByCategory(
            @PathVariable String category) {
        return service.getExpensesByCategory(category);
    }

    // 4. Delete an expense
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExpense(@PathVariable Long id) {
        try {
            service.deleteExpense(id);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }
}