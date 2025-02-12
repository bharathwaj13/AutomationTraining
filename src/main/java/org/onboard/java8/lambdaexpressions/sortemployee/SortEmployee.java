package org.onboard.java8.lambdaexpressions.sortemployee;

import java.util.Arrays;
import java.util.List;

public class SortEmployee {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Developer", 30),
                new Employee("Tester", 28),
                new Employee("Bharath", 25)
        );

        /*Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        });*/

        //Using Lambda

        employees.sort((e1,e2)->e1.getName().compareTo(e2.getName()));

        System.out.println(employees);
    }
}
