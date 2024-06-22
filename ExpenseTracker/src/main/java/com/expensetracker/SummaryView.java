package com.expensetracker;

import javax.swing.*;
import java.awt.*;

public class SummaryView extends JPanel {
    private DataManager dataManager;

    public SummaryView(DataManager dataManager){
        this.dataManager = dataManager;

        setLayout(new GridLayout(3,1));

        JLabel lblTotalIncome = new JLabel("Total Income: R" + dataManager.getTotalIncome());
        JLabel lblTotalExpenses = new JLabel("Total Expenses: R" + dataManager.getTotalExpenses());
        JLabel lblNetTotal = new JLabel("Net Total: R" + (dataManager.getTotalIncome() - dataManager.getTotalExpenses()));

        add(lblTotalIncome);
        add(lblTotalExpenses);
        add(lblNetTotal);
    }
}
