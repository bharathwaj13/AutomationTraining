package org.onboard.collections;

import java.util.*;

public class Task5TreeMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of testcases: ");
        int noOfTestcase = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < noOfTestcase; i++) {
            System.out.println("Please enter the number of queries in testcase"+(i+1)+": ");
            int Q = scanner.nextInt();
            scanner.nextLine();

            TreeMap<Integer, Integer> map = new TreeMap<>();

            List<String> results = new ArrayList<>();

            String[] queries = scanner.nextLine().split(" ");
            for (int j = 0; j < queries.length; j++) {
                String query = queries[j];

                if (query.equals("a")) {
                    int x = Integer.parseInt(queries[++j]);
                    int y = Integer.parseInt(queries[++j]);
                    map.put(x, y);
                } else if (query.equals("b")) {
                    int x = Integer.parseInt(queries[++j]);
                    results.add(map.getOrDefault(x, -1) + "");
                } else if (query.equals("c")) {
                    results.add(map.size() + "");
                } else if (query.equals("d")) {
                    int x = Integer.parseInt(queries[++j]);
                    map.remove(x);
                } else if (query.equals("e")) {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        sb.append(entry.getKey()).append(" ");
                    }
                    results.add(sb.toString());
                }
            }

            System.out.println(String.join(" ", results));
        }

        scanner.close();
    }
}
