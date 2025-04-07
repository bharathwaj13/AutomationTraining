package org.onboard.oops4;

/**
 *
 *  In a home, there are multiple appliances. Each appliance consumes a certain amount of power
 *  when â€œSwitch onâ€. eg: Home can have FAN, Light, TV, Laptop, etc. when "Switch on"
 *  they consume FAN-1 unit, Light - 2 units, TV-3 units etc power. Create a method to calculate
 *  the amount of power consumption at any given point (current load).
 * Sort the devices in an apartment by one of (any) the parameters.
 */

public class MyHome {
    public static void main(String[] args) {
        Home home=new Home();
        home.addAppliances(new Fan());
        home.addAppliances(new Light());
        home.addAppliances(new Laptop());

        home.applianceList.get(0).setSwitchFlag(false);
        home.applianceList.get(1).setSwitchFlag(true);
        home.applianceList.get(2).setSwitchFlag(true);

        home.calculateUnits();
        home.displayUnits();

        home.displayAppliances();
        home.sortAppliances();
        home.displayAppliances();
    }

}
