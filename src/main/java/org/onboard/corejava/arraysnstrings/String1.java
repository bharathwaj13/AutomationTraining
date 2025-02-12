package org.onboard.corejava.arraysnstrings;

import java.util.HashSet;
import java.util.Set;

/**
 * write a program to Print duplicate characters from String
 */

public class String1 {


    public static void main(String[] args) {
        String input = "Bharath";
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (!set.add(input.charAt(i))) System.out.println(input.charAt(i));
        }
    }

}
