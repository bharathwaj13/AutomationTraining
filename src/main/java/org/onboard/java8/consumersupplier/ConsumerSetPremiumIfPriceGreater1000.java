package org.onboard.java8.consumersupplier;

/**
 *
 * PreConditions
 * - Define a Product class with name, price, category, grade
 *
 * Consumer
 *
 * 1. Given a product write a consumer to print the product to appropriate medium depending on the print parameter. If the print parameter is set to file, consumer shall log the product to file, if not print on the console.
 *
 * 2. Write a Consumer to update the grade of the product as 'Premium' if the price is > 1000/-. Given the product list, update the grade for each product and print all of the products.
 *
 * 3. Write a Consumer to update the name of the product to be suffixed with '*' if the price of product is > 3000/-. Given the product list, update the name for each product and print all of the products.
 *
 * 4. Print all the Premium grade products with name suffixed with '*'.
 *
 * Supplier
 *
 * 1. Write a supplier to produce a random product.
 * 2. Write a supplier to produce a random OTP.
 */

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
