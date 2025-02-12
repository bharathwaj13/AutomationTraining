package org.onboard.java8.predicates;

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
