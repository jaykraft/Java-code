package com.expensetracker;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private List<IncomeEntry> incomeEntries;
    private List<ExpenseEntry> expenseEntries;

    public DataManager() {
        incomeEntries = new ArrayList<>();
        expenseEntries = new ArrayList<>();
    }

    public void addIncomeEntry(IncomeEntry entry){
        incomeEntries.add(entry);
    }

    public void addExpenseEntry(ExpenseEntry entry){
        expenseEntries.add(entry);
    }

    public List<IncomeEntry> getIncomeEntries() {
        return incomeEntries;
    }

    public List<ExpenseEntry> getExpenseEntries() {
        return expenseEntries;
    }

    public double getTotalIncome() {
        return incomeEntries.stream().mapToDouble(IncomeEntry::getAmount).sum();
    }

    public double getTotalExpenses() {
        return expenseEntries.stream().mapToDouble(ExpenseEntry::getAmount).sum();
    }
}
