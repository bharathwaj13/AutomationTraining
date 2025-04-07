package org.onboard.java8.lambdaexpressions.sortemployee;

/**
 *
 * Write the below programs with and without help of Lambda expressions
 *
 * 1. Check if a given string is a palindrome
 * 2. Find the 2nd biggest number in the given list of numbers
 * 3. write a program to check if two strings are rotations of each other.
 * 4. Use Runnable interface to start a new thread and print numbers from
 * 5. Use Comparator inerface to sort given list of numbers in reverse order
 * 6. Use Comparator inerface to sort given list of Employees in the alphabetic order of their name
 * 7. Create a TreeSet that sorts the given set of numbers in reverse order
 * 8. Create a TreeSet that sorts the given set of Employees in the alphabetic order of their name
 * 9. Create a TreeMap that sorts the given set of values in decending order
 * 10. Create a TreeMap that sorts the given set of employees in decending order of their name
 * 11. Use Collections.Sort to sort the given list of Employees in decending order of their name
 */

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
