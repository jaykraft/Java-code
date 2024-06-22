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
        setLayout(new GridLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //Initialise components
        JLabel lblAmount = new JLabel("Amount:");
        txtAmount = new JTextField();

        JLabel lblCategory = new JLabel("Category:");
        txtCategory = new JTextField();

        JLabel lblDate = new JLabel("Date (YYYY-MM-DD):");
        txtDate = new JTextField();

        btnAdd = new JButton("Add Income");

        //Add components to panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblAmount, gbc);

        gbc.gridx = 1;
        add(txtAmount, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblCategory, gbc);

        gbc.gridx = 1;
        add(txtCategory, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblDate, gbc);

        gbc.gridx = 1;
        add(txtDate, gbc);

        gbc.gridy = 3;
        add(btnAdd, gbc);

        //Add action listener for button
        btnAdd.addActionListener(e -> addIncome());
    }

    private void addIncome() {
        try {
            double amount = Double.parseDouble(txtAmount.getText());
            String category = txtCategory.getText();
            String date = txtDate.getText();

            //Validate date format
            if (!date.matches("\\d{4}-\\d{2}-\\d{2}")){
                JOptionPane.showMessageDialog(this, "Please enter a valid date (YYYY-MM-DD).");
                return;
            }

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
