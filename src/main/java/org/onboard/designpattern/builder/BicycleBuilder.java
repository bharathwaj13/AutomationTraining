package org.onboard.designpattern.builder;

public class BicycleBuilder {

    private boolean gears;
    private boolean doubleStand;
    private boolean doubleSeats;
    private boolean carrier;

    public BicycleBuilder setGears(boolean gears) {
        this.gears = gears;
        return this;
    }

    public BicycleBuilder setDoubleStand(boolean doubleStand) {
        doubleStand = doubleStand;
        return this;
    }

    public BicycleBuilder setDoubleSeats(boolean doubleSeats) {
        doubleSeats = doubleSeats;
        return this;
    }

    public BicycleBuilder setCarrier(boolean carrier) {
        this.carrier = carrier;
        return this;
    }

    public Bicycle build(){ return new Bicycle(gears,doubleStand,doubleSeats,carrier);
    }


}
