/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javacalculator;

import javax.swing.JOptionPane;

/**
 *
 * @author Jason
 */
public class JavaCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Introduce the program and get input
        String firstNum = JOptionPane.showInputDialog(null, "Welcome to the Simple Calculator"
                + "/nPlease Enter the first number");
        
        String secondNum = JOptionPane.showInputDialog(null, "Please Enter the second number");
        
        String operator = JOptionPane.showInputDialog(null, "Please enter the symbol for the operation to perform"
                + "/n(+) Addition"
                + "/n(-) Subtraction"
                + "/n(*) Multiplication"
                + "/n(/) Division");
        
        switch(operator){
            case "+":
            {
                double result = addition(Integer.parseInt(firstNum), Integer.parseInt(secondNum));
                
                JOptionPane.showMessageDialog(null,"Your answer is " + result);
                
                break;
            }
            case "-":
            {
                double result = subtraction(Integer.parseInt(firstNum), Integer.parseInt(secondNum));
                
                JOptionPane.showMessageDialog(null,"Your answer is " + result);
                
                break;
            }
            case "*":
            {
                double result = multiplication(Integer.parseInt(firstNum), Integer.parseInt(secondNum));
                
                JOptionPane.showMessageDialog(null,"Your answer is " + result);
                
                break;
            }
            case "/":
            {
                double result = division(Integer.parseInt(firstNum), Integer.parseInt(secondNum));
                
                JOptionPane.showMessageDialog(null,"Your answer is " + result);
                
                break;
            }
            default:
            {
                System.out.println("Error: Wrong operation selected");
                break;
            }
        }
        
    }
    
    public static double addition(double firstNum, double secondNum){
        //Calculate the answer by adding the 2 number together
        double result = firstNum + secondNum;
        
        //Returns the calculated value
        return result;
    }
    
    public static double subtraction(double firstNum, double secondNum){
        //Calculate the answer by subtracting the second number from the first
        double result = firstNum - secondNum;
        
        //Returns the calculated value
        return result;
    }
    
    public static double multiplication(double firstNum, double secondNum){
        //Calculate the answer by multiplying the 2 number together
        double result = firstNum * secondNum;
        
        //Returns the calculated value
        return result;
    }
    
    public static double division(double firstNum, double secondNum){
        //Calculate the answer by dividing the first number by the second number
        double result = firstNum / secondNum;
        
        //Returns the calculated value
        return result;
    }
    
}
