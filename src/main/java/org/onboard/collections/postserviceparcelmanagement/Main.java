package org.onboard.collections.postserviceparcelmanagement;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box("Sender1", "Recipient1", 5.5, 2.5, 100, "City1", "Office1"));
        boxes.add(new Box("Sender2", "Recipient1", 4.0, 3.0, 150, "City2", "Office2"));
        boxes.add(new Box("Sender3", "Recipient2", 6.0, 4.0, 200, "City3", "Office3"));

        NewPostOfficeManagementImpl management = new NewPostOfficeManagementImpl(boxes);
        System.out.println(management.getBoxById(2).orElse(null));

        System.out.println(management.getDescSortedBoxesByWeight());

        System.out.println(management.getAscSortedBoxesByCost());

        List<Box> recipient1Boxes = management.getBoxesByRecipient("Recipient1");
        for (Box box : recipient1Boxes) {
            System.out.println(box);
        }
    }
}

