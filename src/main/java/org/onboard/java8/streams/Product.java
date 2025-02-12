package org.onboard.java8.streams;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private String name;
    private double price;
    private String category;
    private int grade;

}
