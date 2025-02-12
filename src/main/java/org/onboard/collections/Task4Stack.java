package org.onboard.collections;

import java.util.Scanner;
import java.util.Stack;

public class Task4Stack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your string: ");
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) break;
            System.out.println(isBalanced(input));
        }
        scanner.close();
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '{' && closing == '}') ||
                (opening == '[' && closing == ']');
    }
}
