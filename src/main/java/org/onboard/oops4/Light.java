package org.onboard.oops4;

public class Light extends Appliance{

    public Light(){
        super("Light",1);
    }

    @Override
    public void usage() {
        System.out.println("Provides light");
    }
}
