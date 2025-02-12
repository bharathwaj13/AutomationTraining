package org.onboard.java8.lambdaexpressions;

import java.util.function.Predicate;

public class PalindromeCheck {

   /* public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }*/

    // Using Lambda Expression
    public static boolean isPalindrome(String str) {
        Predicate<String> palindrome = s -> s.equals(new StringBuilder(s).reverse().toString());
        return palindrome.test(str);
    }

    public static void main(String[] args) {
        String str = "madam";
        System.out.println(isPalindrome(str));
    }
}
