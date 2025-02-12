package org.onboard.java8.consumersupplier;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerUpdateProductName {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Laptop", 3500, "Electronics", "Standard"),
                new Product("Phone", 800, "Electronics", "Standard"),
                new Product("Tablet", 1200, "Electronics", "Standard")
        );

        Consumer<Product> updateNameIfPriceGreaterThan3000 = product -> {
            if (product.getPrice() > 3000) {
                product.setName(product.getName() + "*");
            }
            System.out.println(product);
        };

        products.forEach(updateNameIfPriceGreaterThan3000);
    }
}

