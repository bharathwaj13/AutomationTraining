package org.onboard.java8.functionalinterface;

/**
 *
 * PreConditions
 * - Define a Product class with name, price, category, grade
 *
 * Function Interface
 *
 * 1. Write a function to calculate the cost of all products in a given list of products.
 *
 * 2. Write a function to calculate the cost of all products whose prices is > 1000/- in the given list of products.
 *
 * 3. Write a function to calculate the cost of all electronic products in the given list of products.
 *
 * 4. Write a function to get all the products whose price is is > 1000/- and belongs to electronic category.
 */

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductFunctions {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Laptop", 1200, "Electronics", "A"),
                new Product("Smartphone", 800, "Electronics", "B"),
                new Product("Table", 500, "Furniture", "C"),
                new Product("Headphones", 1500, "Electronics", "A")
        );


        Function<List<Product>, Double> totalCost = productList -> productList.stream()
                .mapToDouble(Product::getPrice)
                .sum();

        double totalCostOfAllProducts = totalCost.apply(products);
        System.out.println("Total cost of all products: " + totalCostOfAllProducts);

        //==================================================================================================

        Function<List<Product>,Double> totalCostOfProductsGreaterThan1000 = productList -> productList.stream()
                .filter(p->p.getPrice()>1000).mapToDouble(Product::getPrice).sum();

        totalCostOfAllProducts = totalCostOfProductsGreaterThan1000.apply(products);
        System.out.println("\nTotal cost of all products greater than 1000: " + totalCostOfAllProducts);

        //==================================================================================================

        Function<List<Product>,Double> totalCostOfElectronicProducts = productList -> productList.stream()
                .filter(p->p.getCategory().equalsIgnoreCase("electronics")).mapToDouble(Product::getPrice).sum();

        totalCostOfAllProducts = totalCostOfElectronicProducts.apply(products);
        System.out.println("\nTotal cost of all electronic products: " + totalCostOfAllProducts);

        //==================================================================================================

        Function<List<Product>, List<Product>> productsGreaterThan1000AndElectronics = productList -> productList.stream()
                .filter(p -> p.getPrice() > 1000 && "Electronics".equalsIgnoreCase(p.getCategory()))
                .collect(Collectors.toList());

        List<Product> filteredProducts = productsGreaterThan1000AndElectronics.apply(products);
        System.out.println("\nProducts with price > 1000 and category Electronics:");
        filteredProducts.forEach(System.out::println);
    }
}
