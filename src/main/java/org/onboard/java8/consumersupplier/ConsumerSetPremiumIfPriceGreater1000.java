package org.onboard.java8.consumersupplier;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerSetPremiumIfPriceGreater1000 {

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Laptop", 1500, "Electronics", "Standard"),
                new Product("Phone", 800, "Electronics", "Standard"),
                new Product("Tablet", 1200, "Electronics", "Standard")
        );

        Consumer<Product> updateGradeToPremium = product -> {
            if (product.getPrice() > 1000) {
                product.setGrade("Premium");
            }
            System.out.println(product);
        };

        products.forEach(updateGradeToPremium);

        /*products.stream().filter(product -> product.getPrice()>1000).forEachOrdered(p->p.setGrade("Premium"));
        products.forEach(System.out::println);*/
    }
}
