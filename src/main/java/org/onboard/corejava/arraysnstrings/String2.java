package org.onboard.corejava.arraysnstrings;

/**
 * write a program to check if two strings are rotations of each other
 */

public class String2 {

    public static void main(String[] args) {
        String firstName = "Bharath";
        String secondName = "rathbha";
        String temp = "";

        if (firstName.equalsIgnoreCase(secondName)) {
            System.out.println("The 2 strings are rotations of each other");
            System.exit(0);
        } else if (firstName.length() != secondName.length()) {
            System.out.println("The 2 strings are not rotations");
            System.exit(0);
        } else {
            for (int i = 0; i < firstName.length(); i++) {
                temp = firstName.substring(i + 1, firstName.length()) + firstName.substring(0, i + 1);
                if (temp.equalsIgnoreCase(secondName)) {
                    System.out.println("The 2 strings are rotations of each other");
                    break;
                }
                temp = "";
            }
            System.out.println("The 2 strings are not rotations of each other");
        }
    }
}
