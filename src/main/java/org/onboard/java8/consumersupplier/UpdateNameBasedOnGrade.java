package org.onboard.java8.consumersupplier;

import java.util.List;
import java.util.function.Consumer;

public class UpdateNameBasedOnGrade {

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Laptop", 3500, "Electronics", "Premium"),
                new Product("Phone", 800, "Electronics", "Standard"),
                new Product("Tablet", 1200, "Electronics", "Premium")
        );

        Consumer<Product> printPremiumProducts = product -> {
            if ("Premium".equalsIgnoreCase(product.getGrade())) {
                product.setName(product.getName() + "*");
                System.out.println(product);
            }
        };

        products.forEach(printPremiumProducts);
    }
}
