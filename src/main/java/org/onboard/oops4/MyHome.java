package org.onboard.oops4;

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
