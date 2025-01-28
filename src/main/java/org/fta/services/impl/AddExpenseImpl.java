package org.fta.services.impl;


import org.fta.dto.ExpenseDto;
import org.fta.entities.Category;
import org.fta.entities.Expense;
import org.fta.entities.User;
import org.fta.exceptions.ResourceNotFoundException;
import org.fta.repositories.CategoryInfoRepository;
import org.fta.repositories.ExpenseInfoRepository;
import org.fta.repositories.UserInfoRepository;
import org.fta.services.AddEntry;
import org.springframework.beans.factory.annotation.Autowired;

public class AddExpenseImpl implements AddEntry {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private ExpenseInfoRepository expenseInfoRepository;

    @Autowired
    private CategoryInfoRepository categoryInfoRepository;


    public void addExpense(ExpenseDto expenseDto) {
        User user = userInfoRepository.findById(expenseDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Category category = categoryInfoRepository.findById(expenseDto.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        Expense expense = Expense.builder()
                .user(user)
                .expenseDateTime(expenseDto.getExpenseDateTime())
                .expenseCategory(category)
                .expenseAmount(expenseDto.getAmount())
                .expenseDescription(expenseDto.getExpenseDescription()).build();

        expenseInfoRepository.save(expense);

        user.getExpenses().add(expense);
        userInfoRepository.save(user);
    }
}
