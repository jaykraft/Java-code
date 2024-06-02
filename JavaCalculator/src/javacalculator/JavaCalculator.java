/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javacalculator;

import javax.swing.JOptionPane;

/*
 * @author Jason
 */
public class JavaCalculator {
    public static void main(String[] args) {

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
