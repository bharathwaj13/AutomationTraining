package org.onboard.java8.bifunction;

import java.util.function.BiFunction;

public class CreateProduct {

    public static void main(String[] args) {
        BiFunction<String, Double, Product> biFunction = (name, price) -> {
            return new Product(name, price, "Electronics", "Standard");
        };

        Product laptop = biFunction.apply("Laptop", 35000.00);
        System.out.println(laptop);
    }
}
