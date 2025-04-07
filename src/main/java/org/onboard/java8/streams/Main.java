package org.onboard.java8.streams;

/**
 *
 * PreConditions
 * - Define a Product class with name, price, category, grade
 * - Define a Response class with response body, status code, response type
 *
 *
 * 1. From the given list of the products get all the products with price > 1000/-
 * 2. From the given list of the products get all the products from electronics category.
 * 3. From the given list of the products get all the products with price> 1000/- and from electronics category. Change the name of the result list into CAP letters before printing.
 * 4. Calculate the count of all electronic products in the given list of products.
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
                new Product("Laptop", 1500, "Electronics", 4),
                new Product("Smartphone", 800, "Electronics", 5),
                new Product("Jeans", 700, "Apparel", 4),
                new Product("Washing Machine", 2000, "Electronics", 5)
        );


        List<Product> productsGreaterThan1000 = products.stream().filter(p -> p.getPrice() > 1000).toList();

        System.out.println("\nproductsGreaterThan1000");
        productsGreaterThan1000.forEach(System.out::println);

        List<Product> electronicProducts = products.stream().filter(p -> p.getCategory().equalsIgnoreCase("electronics")).toList();
        System.out.println("\nelectronicProducts");
        electronicProducts.forEach(System.out::println);

        List<Product> electronicProductsGreaterThan1000 = products.stream()
                .filter(p -> p.getPrice() > 1000 && p.getCategory().equalsIgnoreCase("electronics"))
                .map(p -> new Product(p.getName().toUpperCase(), p.getPrice(), p.getCategory(), p.getGrade()))
                .toList();

        System.out.println("\nelectronicProductsGreaterThan1000");
        electronicProductsGreaterThan1000.forEach(System.out::println);

        long electronicsCount = products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("electronics")).count();
        System.out.println("\nelectronicsCount: " +electronicsCount);

    }
}
