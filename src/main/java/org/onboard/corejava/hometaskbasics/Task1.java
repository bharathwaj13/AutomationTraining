package org.onboard.corejava.hometaskbasics;

import java.util.Scanner;

public class Task1 {

    /**
     * Create code which displays in console “Hello, NAME”, where NAME is taken from Command line (1 mark)
     */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scan.next();
        System.out.println("Hello, " + name);
        scan.close();
    }
}
