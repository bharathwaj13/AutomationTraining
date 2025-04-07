package org.onboard.java8.bifunction;

/**
 *
 * PreConditions
 * - Define a Product class with name, price, category, grade
 *
 * BiFunction
 *
 * 1. Given the name and price of the product, write a Bifunction to create a product.
 *
 * 2. Given the Product and quantity of the products, write a BiFunction to calculate the cost of products. A cart is a map of product and quantity. Given the cart, calculate the cost of the cart.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class ProductBiFunction {

    public static void main(String[] args) {

        BiFunction<String, Double, Product> createProduct = (name, price) -> new Product(name, price, "Electronics", "Standard");

        Product laptop = createProduct.apply("Laptop", 1500.00);
        Product phone = createProduct.apply("Phone", 800.00);

        BiFunction<Product, Integer, Double> calculateCost = (product, quantity) -> product.getPrice() * quantity;

        Map<Product, Integer> cart = new HashMap<>();
        cart.put(laptop, 2);
        cart.put(phone, 3);

        double totalCost = cart.entrySet().stream()
                .mapToDouble(entry -> calculateCost.apply(entry.getKey(), entry.getValue()))
                .sum();

        System.out.println("Total Cost of Cart: " + totalCost);
    }
}
