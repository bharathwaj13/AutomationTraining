package org.onboard.oops4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Home {

    public List<Appliance> applianceList;
    private int totalUnits;

    public Home() {
        this.applianceList = new ArrayList<>();
    }

    public void addAppliances(Appliance appliance) {
        applianceList.add(appliance);
    }

    public void calculateUnits() {
        for (Appliance eachApp : applianceList) {
            if (eachApp.isSwitchFlag()) totalUnits += eachApp.getUnits();
        }
    }

    public void displayUnits() {
        System.out.println("The total units of the switched on appliances: " + totalUnits);
    }

    public void sortAppliances(){
        applianceList.sort(Comparator.comparingInt(Appliance::getUnits));
        System.out.println("Appliances sorted based on Units");
    }

    public void displayAppliances(){
        for (Appliance eachApp:applianceList){
            System.out.println(eachApp.getName());
        }
    }


}
