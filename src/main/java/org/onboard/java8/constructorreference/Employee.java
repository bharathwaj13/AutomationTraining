package org.onboard.java8.constructorreference;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Employee {

    private String name;
    private String account;
    private double salary;

    public Employee(String name,String account) {
        this.name=name;
        this.account=account;
        this.salary=50000;
    }
}
