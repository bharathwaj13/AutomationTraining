package org.onboard.corejava.loops;

import java.util.Scanner;

public class Task1DoWhileLoop {

    /**
     * Generate Pyramid For a Given Number Example
     * <p>
     * --> Generate the Pyramid with Do while loop
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
        int value = 0, numColumns = 1, rowCount = 1;
        do {
            do {
                System.out.print(value + " ");
                value += num2;
                numColumns++;
            } while (numColumns <= rowCount);
            System.out.println();
            numColumns = 1;
            rowCount++;
            num1--;
        } while (num1 > 0);

    }


}
