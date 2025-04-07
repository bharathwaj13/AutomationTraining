package org.onboard.designpattern.builder;

/**
 *
 * While manufacturing a Bicycle, I provide flexibility to my customer to choose if they want gears, double stands, double seats, carrier etc. A customer can opt-in or opt-out for any of the choises I provide. However once the choice is made the choice can not be changed.
 *
 * Write code to represent this model and build a bicycle , leaving the flexibility of selection of extra fittings to the customer.
 */

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
