package org.onboard.designpattern.builder;

public class Main {

    public static void main(String[] args) {
        Bicycle bicycle1 = new BicycleBuilder()
                .setGears(true)
                .setCarrier(true)
                .build();
        System.out.println("Customer 1 Bicycle: " + bicycle1);

        Bicycle bicycle2 = new BicycleBuilder()
                .setDoubleStand(true)
                .setDoubleSeats(true)
                .build();
        System.out.println("Customer 2 Bicycle: " + bicycle2);
    }
}
