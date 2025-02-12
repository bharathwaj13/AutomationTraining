package org.onboard.java8.consumersupplier;

import java.util.Random;
import java.util.function.Supplier;

public class RandomProductSupplier {

    public static void main(String[] args) {

        Supplier<Product> randomProductSupplier = () -> {
            Random random = new Random();
            String[] names = {"Laptop", "Phone", "Tablet", "Headphones"};
            String[] categories = {"Electronics", "Furniture", "Clothing"};
            String[] grades = {"Standard", "Premium"};
            double price = (double) Math.round(random.nextDouble(5000) * 100) /100;

            String name = names[random.nextInt(names.length)];
            String category = categories[random.nextInt(categories.length)];
            String grade = grades[random.nextInt(grades.length)];

            return new Product(name, price, category, grade);
        };

        Product randomProduct = randomProductSupplier.get();
        System.out.println("Random Product: " + randomProduct);
    }
}
