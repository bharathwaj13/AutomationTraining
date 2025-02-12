package org.onboard.java8.lambdaexpressions.treesetemployeesort;

import java.util.Set;
import java.util.TreeSet;

public class EmployeeTreeSet {

    public static void main(String[] args) {
        /*Set<Employee> set = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        });*/

        //With Lambda

        Set<Employee> set=new TreeSet<>((e1,e2)->e1.getName().compareTo(e2.getName()));

        set.add(new Employee("Tester", 30));
        set.add(new Employee("Developer", 28));
        set.add(new Employee("Bharath", 25));
        System.out.println(set);
    }
}
