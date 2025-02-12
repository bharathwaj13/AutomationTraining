package org.onboard.corejava.arraysnstrings;

import java.util.Arrays;

public class Arrays2 {

    /**
     * Write a program to find biggest and smallest number in a array.
     */

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 10};
        System.out.println("Smallest number is: " + Arrays.stream(input).min());
        System.out.println("Largest number is: " + Arrays.stream(input).max());
    }
}
