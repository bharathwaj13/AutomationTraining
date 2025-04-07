package org.onboard.java8.predicates;

/**
 *
 * PreConditions
 * - Define a Product class with name, price, category, grade
 * - Define a Response class with response body, status code, response type
 *
 * Predicates
 *
 * 1. Define a predicate to check if the price of given product is greaterthan 1000/-. Print all the products from the given list of the products if the price is greaterthan 1000/-.
 *
 * 2. Define a predicate to check if the product is of electronics category. Print all the products from the given list of the products if the product is of electronics category.
 *
 * 3. Print all the products from the given list of product if the product price is greaterthan 100/- which are in electronics category.
 *
 * 4. Print all the products from the given list of product if the product price is greaterthan 100/- or product is in electronics category.
 *
 * 5. Print all the products from the given list of product if the product price is lessthan 100/- and product is in electronics category.
 *
 * 6. Define a predicate to check if the status code is 400. Print all the responses with status code 400 from the given list of responses.
 *
 * 7. Define a predicate to check if the response type JSON. Print all the responses the response type JSON from the given list of responses.
 *
 * 8. Print all the responses with status code 400 and response type JSON
 *
 * 9. Print all the responses with status code 400 or response type JSON
 *
 * 10. Print all the responses with status code is not 400 and response type JSON
 */

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilterUsingPredicate {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1200, "Electronics", "A"),
                new Product("Smartphone", 800, "Electronics", "B"),
                new Product("Table", 500, "Furniture", "C"),
                new Product("Headphones", 1500, "Electronics", "A")
        );

        //============================================================================================
        Predicate<Product> priceGreaterThan1000 = p -> p.getPrice() > 1000;

        System.out.println("priceGreaterThan1000: ");
        products.stream()
                .filter(priceGreaterThan1000)
                .forEach(System.out::println);
        //============================================================================================

        Predicate<Product> isProductElectronics = p -> p.getCategory().equalsIgnoreCase("electronics");
        System.out.println("\nisProductElectronics: ");
        products.stream().filter(isProductElectronics).forEach(System.out::println);

        //============================================================================================

        Predicate<Product> priceGreaterThan100 = p -> p.getPrice() > 100;
        Predicate<Product> priceGreaterThan100AndElectronics = priceGreaterThan100.and(isProductElectronics);
        System.out.println("\npriceGreaterThan100AndElectronics: ");
        products.stream().filter(priceGreaterThan100AndElectronics).forEach(System.out::println);

        //============================================================================================

        Predicate<Product> priceGreaterThan100OrElectronics = priceGreaterThan100.or(isProductElectronics);
        System.out.println("\npriceGreaterThan100OrElectronics: ");
        products.stream().filter(priceGreaterThan100OrElectronics).forEach(System.out::println);

        //============================================================================================

        Predicate<Product> priceLesserThan100 = p -> p.getPrice() < 100;
        Predicate<Product> priceLesserThan100OrElectronics = priceLesserThan100.or(isProductElectronics);
        System.out.println("\npriceLesserThan100OrElectronics: ");
        products.stream().filter(priceLesserThan100OrElectronics).forEach(System.out::println);

        //============================================================================================

        Predicate<Product> priceLesserThan100AndElectronics = priceLesserThan100.and(isProductElectronics);
        System.out.println("\npriceLesserThan100AndElectronics: ");
        products.stream().filter(priceLesserThan100AndElectronics).forEach(System.out::println);

        //============================================================================================

        List<Response> responses = Arrays.asList(
                new Response("Bad Request", 400, "JSON"),
                new Response("OK", 200, "JSON"),
                new Response("Not Found", 404, "XML")
        );

        System.out.println("\nstatusCodeIs400: ");
        Predicate<Response> statusCodeIs400 = r -> r.getStatusCode() == 400;
        responses.stream().filter(statusCodeIs400).forEach(System.out::println);

        //============================================================================================

        System.out.println("\nisResponseTypeJson: ");
        Predicate<Response> isResponseTypeJson=r-> r.getResponseType().equalsIgnoreCase("json");
        responses.stream().filter(isResponseTypeJson).forEach(System.out::println);

        //============================================================================================

        System.out.println("\nisResponseTypeJsonAndStatusCode400: ");
        Predicate<Response> isResponseTypeJsonAndStatusCode400=statusCodeIs400.and(isResponseTypeJson);
        responses.stream().filter(isResponseTypeJsonAndStatusCode400).forEach(System.out::println);

        //============================================================================================

        System.out.println("\nisResponseTypeJsonOrStatusCode400: ");
        Predicate<Response> isResponseTypeJsonOrStatusCode400=statusCodeIs400.or(isResponseTypeJson);
        responses.stream().filter(isResponseTypeJsonOrStatusCode400).forEach(System.out::println);

        //============================================================================================

        System.out.println("\nisResponseTypeJsonAndNotStatusCode400: ");
        Predicate<Response> isResponseTypeJsonAndNotStatusCode400=statusCodeIs400.negate().and(isResponseTypeJson);
        responses.stream().filter(isResponseTypeJsonAndNotStatusCode400).forEach(System.out::println);

    }
}
