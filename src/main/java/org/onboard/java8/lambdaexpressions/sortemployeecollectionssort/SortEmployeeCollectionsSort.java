package org.onboard.java8.lambdaexpressions.sortemployeecollectionssort;

import org.onboard.java8.lambdaexpressions.sortemployee.Employee;

import java.util.Arrays;
import java.util.List;

public class SortEmployeeCollectionsSort {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Developer", 30),
                new Employee("Tester", 28),
                new Employee("Bharath", 25)
        );

        /*Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e2.getName().compareTo(e1.getName());
            }
        });*/

        //Using Lambda

        employees.sort((e1,e2)->e2.getName().compareTo(e1.getName()));

        System.out.println(employees);
    }
}
