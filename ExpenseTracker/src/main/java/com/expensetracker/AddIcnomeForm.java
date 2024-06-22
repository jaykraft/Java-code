package com.expensetracker;

import javax.swing.*;
import java.awt.*;

public class AddIcnomeForm extends JPanel {
    private JTextField txtAmount;
    private JTextField txtCategory;
    private JTextField txtDate;
    private JButton btnAdd;

    private DataManager dataManager;

    public AddIcnomeForm(DataManager dataManager) {
        this.dataManager = dataManager;

        //Set layout
        setLayout(new GridLayout(4, 2));

        //Initialise components
        JLabel lblAmount = new JLabel("Amount:");
        txtAmount = new JTextField();

        JLabel lblCategory = new JLabel("Category:");
        txtCategory = new JTextField();

        JLabel lblDate = new JLabel("Date (YYYY-MM-DD):");
        txtDate = new JTextField();

        btnAdd = new JButton("Add Income");

        //Add components to panel
        add(lblAmount);
        add(txtAmount);
        add(lblCategory);
        add(txtCategory);
        add(lblDate);
        add(txtDate);
        add(new JLabel()); //Empty label for spacing
        add(btnAdd);

        //Add action listener for button
        btnAdd.addActionListener(e -> addIncome());
    }

    private void addIncome() {
        try {
            double amount = Double.parseDouble(txtAmount.getText());
            String category = txtCategory.getText();
            String date = txtDate.getText();

            dataManager.addIncomeEntry(new IncomeEntry(amount, category, date));
            JOptionPane.showMessageDialog(this, "Income added successfully");

            //Clear fields
            txtAmount.setText("");
            txtCategory.setText("");
            txtDate.setText("");
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Please enter a valid amount.");
        }
    }
}
