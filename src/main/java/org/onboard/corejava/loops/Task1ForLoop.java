package org.onboard.corejava.loops;

import java.util.Scanner;

public class Task1ForLoop {

    /**
     * Generate Pyramid For a Given Number Example
     * <p>
     * --> Generate the Pyramid with For loop
     * <p>
     * Enter Number:
     * 5
     * Enter X:
     * 1
     * <p>
     * 0
     * 1	2
     * 3	4	5
     * 6	7	8	9
     * 10	11	12	13	14
     * <p>
     * <p>
     * Enter Number:
     * 5
     * Enter X:
     * 2
     * <p>
     * 0
     * 2	4
     * 6	8	10
     * 12	14	16	18
     * 20	22	24	26	28
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ënter the number:");
        int num1 = scan.nextInt();
        System.out.println("Enter X:");
        int num2 = scan.nextInt();
        int value = 0;
        for (int i = 1; i <= num1; i++) {
            for (int numColumns = 1; numColumns <= i; numColumns++) {
                System.out.print(value + " ");
                value += num2;
            }
            System.out.println();
        }

    }


}
