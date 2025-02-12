package org.onboard.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3Map {

    public static void main(String[] args) {
        System.out.println("Please enter the number of contacts: ");
        Scanner scan = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        int n = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the contact's name: ");
            String name = scan.nextLine().trim();
            System.out.println("Enter the contact's phone number: ");
            String phoneNum = scan.next().trim();
            map.put(name, phoneNum);
            scan.nextLine();
        }
        System.out.println("Please enter the person's name to query: ");
        while (true) {
            String query = scan.nextLine().trim();
            if(query.isEmpty()){
                break;
            }
            String output = map.getOrDefault(query, "Not found");
            System.out.println(query + " = " + output);
        }
        scan.close();
    }
}
