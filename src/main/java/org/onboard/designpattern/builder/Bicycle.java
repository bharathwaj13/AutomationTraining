package org.onboard.designpattern.builder;

import lombok.ToString;

@ToString
class Bicycle {

    private final boolean gears;
    private final boolean doubleStand;
    private final boolean doubleSeats;
    private final boolean carrier;


    public Bicycle(boolean gears,boolean doubleStand,boolean doubleSeats,boolean carrier) {
        this.gears = gears;
        this.doubleStand = doubleStand;
        this.doubleSeats = doubleSeats;
        this.carrier = carrier;
    }

    public boolean isGears() {
        return gears;
    }

    public boolean isDoubleStand() {
        return doubleStand;
    }

    public boolean isDoubleSeats() {
        return doubleSeats;
    }

    public boolean isCarrier() {
        return carrier;
    }

}
