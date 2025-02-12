package org.onboard.collections.cashboxqueue;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop(5);  // Create a shop with 5 cashboxes

        // Initial state
        System.out.println("Initial state");
        shop.print();
        System.out.println("==============");

        // Enable some cashboxes and add buyers
        shop.setCashBoxState(0, State.ENABLED);
        shop.setCashBoxState(2, State.ENABLED);
        shop.setCashBoxState(4, State.ENABLED);
        shop.print();
        System.out.println("==============");

        // Add some buyers
        for (int i = 0; i < 5; i++) {
            shop.addBuyer(new Buyer(String.valueOf((char) ('A' + i))));
        }
        shop.print();
        System.out.println("==============");

        // Add more buyers
        for (int i = 5; i < 13; i++) {
            shop.addBuyer(new Buyer(String.valueOf((char) ('A' + i))));
        }
        shop.print();
        System.out.println("==============");

        // Set cashbox 2 to closing
        shop.setCashBoxState(2, State.IS_CLOSING);
        shop.print();
        System.out.println("==============");

        // Perform one tact
        shop.tact();
        shop.print();
        System.out.println("==============");

        // Enable other cashboxes and add buyers
        shop.setCashBoxState(1, State.ENABLED);
        shop.setCashBoxState(3, State.ENABLED);
        for (int i = 13; i < 20; i++) {
            shop.addBuyer(new Buyer(String.valueOf((char) ('A' + i))));
        }
        shop.print();
        System.out.println("==============");

        // Perform more tacts
        shop.tact();
        shop.print();
        System.out.println("==============");

        shop.tact();
        shop.print();
    }
}
