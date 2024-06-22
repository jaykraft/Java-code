package com.expensetracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SummaryView extends JPanel {
    private DataManager dataManager;
    private JTable table;
    private Object[][] data;
    private String[] columnNames = {"Type", "Amount", "Category", "Date"};

    public SummaryView(DataManager dataManager) {
        this.dataManager = dataManager;

        setLayout(new BorderLayout());

        JPanel summaryPanel = new JPanel(new GridLayout(3, 1));
        JLabel lblTotalIncome = new JLabel("Total Income: R" + dataManager.getTotalIncome());
        JLabel lblTotalExpenses = new JLabel("Total Expenses: R" + dataManager.getTotalExpenses());
        JLabel lblNetTotal = new JLabel("Net Total: R" + (dataManager.getTotalIncome() - dataManager.getTotalExpenses()));

        summaryPanel.add(lblTotalIncome);
        summaryPanel.add(lblTotalExpenses);
        summaryPanel.add(lblNetTotal);

        add(summaryPanel, BorderLayout.NORTH);

        refreshTableData();

        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton btnEdit = new JButton("Edit");
        JButton btnDelete = new JButton("Delete");

        buttonPanel.add(btnEdit);
        buttonPanel.add(btnDelete);
        add(buttonPanel, BorderLayout.SOUTH);

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editEntry();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEntry();
            }
        });
    }

    private void refreshTableData() {
        List<IncomeEntry> incomeEntries = dataManager.getIncomeEntries();
        List<ExpenseEntry> expenseEntries = dataManager.getExpenseEntries();
        data = new Object[incomeEntries.size() + expenseEntries.size()][4];

        int row = 0;
        for (IncomeEntry entry : incomeEntries) {
            data[row][0] = "Income";
            data[row][1] = entry.getAmount();
            data[row][2] = entry.getCategory();
            data[row][3] = entry.getDate();
            row++;
        }

        for (ExpenseEntry entry : expenseEntries) {
            data[row][0] = "Expense";
            data[row][1] = entry.getAmount();
            data[row][2] = entry.getCategory();
            data[row][3] = entry.getDate();
            row++;
        }
    }

    private void editEntry() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String type = (String) table.getValueAt(selectedRow, 0);
            double amount = (double) table.getValueAt(selectedRow, 1);
            String category = (String) table.getValueAt(selectedRow, 2);
            String date = (String) table.getValueAt(selectedRow, 3);

            if (type.equals("Income")) {
                IncomeEntry entry = new IncomeEntry(amount, category, date);
                dataManager.updateIncomeEntry(selectedRow, entry);
            } else {
                ExpenseEntry entry = new ExpenseEntry(amount, category, date);
                dataManager.updateExpenseEntry(selectedRow, entry);
            }

            refreshTableData();
            table.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Please select an entry to edit.");
        }
    }

    private void deleteEntry() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String type = (String) table.getValueAt(selectedRow, 0);

            if (type.equals("Income")) {
                dataManager.removeIncomeEntry(selectedRow);
            } else {
                dataManager.removeExpenseEntry(selectedRow);
            }

            refreshTableData();
            table.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Please select an entry to delete.");
        }
    }
}