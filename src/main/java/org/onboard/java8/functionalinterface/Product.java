package org.onboard.java8.functionalinterface;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private String name;
    private double price;
    private String category;
    private String grade;
}
