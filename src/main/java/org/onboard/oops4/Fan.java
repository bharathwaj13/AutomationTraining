package org.onboard.oops4;

public class Fan extends Appliance{

    public Fan(){
        super("Fan",2);
    }

    @Override
    public void usage() {
        System.out.println("Provides breeze");
    }
}
