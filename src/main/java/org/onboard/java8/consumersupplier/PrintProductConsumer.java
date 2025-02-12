package org.onboard.java8.consumersupplier;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.Consumer;

public class PrintProductConsumer {

    public static void main(String[] args) {
        Product product = new Product("Laptop", 1500, "Electronics", "Standard");
        Consumer<Product> consumer = p -> {
            String printTo = "console";
            if ("file".equalsIgnoreCase(printTo)) {
                try (PrintWriter writer = new PrintWriter(new FileWriter("product_log.txt", true))) {
                    writer.println(p);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else System.out.println(p);
        };

        consumer.accept(product);
    }
}
