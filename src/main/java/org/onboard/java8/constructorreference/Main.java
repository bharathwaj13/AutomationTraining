package org.onboard.java8.constructorreference;

/**
 *
 * Constructor Reference
 *
 * 1. Write a program get the details of Employee Object , such as name,account,salary , where Employee class has parameterized constructor using constructor reference
 */

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

       // Function<String,Employee> createEmployee = (name) -> new Employee(name,"account1",5000);

        BiFunction<String,String,Employee> createEmployee = Employee::new;

        Employee emp1 = createEmployee.apply("Bharath","account1");
        Employee emp2 = createEmployee.apply("Tester","account2");

        System.out.println(emp1);
        System.out.println(emp2);
    }
}
