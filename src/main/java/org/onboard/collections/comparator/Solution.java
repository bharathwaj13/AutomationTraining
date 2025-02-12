package org.onboard.collections.comparator;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the number of players: ");
        int n = scan.nextInt();
        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the player" + (i + 1) + " name");
            String name = scan.next();
            System.out.println("Enter the player" + (i + 1) + " score");
            int score = scan.nextInt();
            scan.nextLine();
            players[i] = new Player(name, score);
        }

        Arrays.sort(players, new Checker());

        for (Player player : players) {
            System.out.println(player.getName() + " " + player.getScore());
        }
    }
}
