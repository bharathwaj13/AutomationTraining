package org.onboard.oops4;

public class Television extends Appliance{

    public Television(){
        super("TV",2);
    }

    @Override
    public void usage() {
        System.out.println("Provides entertainment though channels");
    }
}
