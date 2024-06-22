package com.expensetracker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpenseTrackerApp {
    private JFrame frame;
    private DataManager dataManager;

    public ExpenseTrackerApp() {
        dataManager = new DataManager();

        //Main frame
        frame = new JFrame("Expense Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        //Initialise the Menu bar
        JMenuBar menuBar = new JMenuBar();

        //Initialise the menus
        JMenu menuAdd = new JMenu("Add");
        JMenu menuView = new JMenu("View");

        //Initialise menu items
        JMenuItem menuItemAddIncome = new JMenuItem("Add Income");
        JMenuItem menuItemAddExpense = new JMenuItem("Add Expense");
        JMenuItem menuItemViewSummary = new JMenuItem("View Summary");

        //Add action listeners for menu items
        menuItemAddIncome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddIncomeForm();
            }
        });

        menuItemAddExpense.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddExpenseForm();
            }
        });

        menuItemViewSummary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSummaryView();
            }
        });

        //Add menu items to menu
        menuAdd.add(menuItemAddIncome);
        menuAdd.add(menuItemAddExpense);
        menuView.add(menuItemViewSummary);

        //Add menus to menu bar
        menuBar.add(menuAdd);
        menuBar.add(menuView);

        //Set the menu bar to the frame
        frame.setJMenuBar(menuBar);

        //Display the frame
        frame.setVisible(true);
    }

    private void showAddIncomeForm(){
        //Clear the frame and add the Add Income form
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new AddIcnomeForm(dataManager));
        frame.revalidate();
        frame.repaint();
    }

    private void showAddExpenseForm(){
        //Clear the frame and add the Add Expense form
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new AddExpenseForm(dataManager));
        frame.revalidate();
        frame.repaint();
    }

    private void showSummaryView(){
        //Clear the frame and add the Summary view
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new SummaryView(dataManager));
        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args){
        //Run the application
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ExpenseTrackerApp();
            }
        });
    }
}
