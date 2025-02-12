package org.onboard.oops4;

import lombok.Data;

@Data
public abstract class Appliance {

    private String name;
    private int units;
    private boolean switchFlag;

    public Appliance(String name, int units){
        this.name = name;
        this.units=units;
    }

    public abstract void usage();
}
