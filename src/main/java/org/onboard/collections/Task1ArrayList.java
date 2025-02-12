package org.onboard.collections;

import java.util.ArrayList;
import java.util.Scanner;

public class Task1ArrayList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of lines of input: ");
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<ArrayList<Integer>> lines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the data in Line"+(i+1)+" followed by a space");
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            int lineSize = Integer.parseInt(parts[0]);

            ArrayList<Integer> currentLine = new ArrayList<>();
            for (int j = 1; j <= lineSize; j++) {
                currentLine.add(Integer.parseInt(parts[j]));
            }
            lines.add(currentLine);
        }

        System.out.println("Please enter the number of lines of query: ");
        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            System.out.println("Enter the data in query"+(i+1)+" followed by a space");
            int x = sc.nextInt();
            int y = sc.nextInt();

            x--;
            y--;
            if (x >= 0 && x < lines.size() && y >= 0 && y < lines.get(x).size()) {
                System.out.println(lines.get(x).get(y));
            } else {
                System.out.println("ERROR!");
            }
        }
        sc.close();
    }
}
