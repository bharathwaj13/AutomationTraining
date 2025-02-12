package org.onboard.java8.lambdaexpressions.treemapemployeesort;

import java.util.Map;
import java.util.TreeMap;

public class EmployeeReverseTreeMap {

    public static void main(String[] args) {

       /* Map<String, Employee> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });*/

        //Using Lambda

        Map<String,Employee> map=new TreeMap<>((s1,s2)-> s2.compareTo(s1));


        map.put("Developer", new Employee("Developer", 28));
        map.put("Bharath", new Employee("Bharath", 25));
        map.put("Tester", new Employee("Tester", 30));
        System.out.println(map);
    }
}
