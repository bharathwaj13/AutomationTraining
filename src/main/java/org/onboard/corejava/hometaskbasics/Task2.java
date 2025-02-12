package org.onboard.corejava.hometaskbasics;

import java.util.Scanner;

/**
 * Create "calculator" which takes two numbers and an operation from the command line and outputs the result of the operation to the console. Add addition, subtraction, multiplication and division. (4 marks)
 *
 * Extra task : provide option for reminder, calcualte percentage (2 marks)
 */

public class Task2 {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Number1 and press Enter: ");
        int firstNum = scan.nextInt();
        System.out.println("Enter Number2 and press Enter: ");
        int secondNum = scan.nextInt();
        System.out.println("Enter the operation to perform (Addition|Subtraction|Multiplication|Division|Reminder|Percentage): ");
        String operation = scan.next();
        scan.close();
        performOperation(firstNum, secondNum, operation);
    }

    private static void performOperation(int num1, int num2, String operation) {
        Object result = switch (operation) {
            case "Addition" -> num1 + num2;
            case "Subtraction" -> Math.abs(num1 - num2);
            case "Multiplication" -> num1 * num2;
            case "Division" -> num1 / num2;
            case "Reminder" -> num1 % num2;
            case "Percentage" -> num1 / num2 * 100;
            default -> "Invalid operation";
        };
        System.out.println("Result: " + result);
    }
}
