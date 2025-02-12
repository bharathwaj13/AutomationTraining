package org.onboard.oops4;

public class Laptop extends Appliance {

    public Laptop() {
        super("Laptop", 3);
    }

    @Override
    public void usage() {
        System.out.println("Provides entertainment,games also work purposes");
    }
}
