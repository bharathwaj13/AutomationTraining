package org.onboard.collections.poststorageservice;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Box box1 = new Box("Bharath", "EPAM", 5.0, 0.1, BigDecimal.valueOf(10), "Chennai", 1);
        Box box2 = new Box("EPAM", "Bharath", 3.0, 0.2, BigDecimal.valueOf(20), "Chennai", 2);

        NewPostOfficeStorageImpl storage = new NewPostOfficeStorageImpl();
        storage.acceptBox(box1);
        storage.acceptBox(box2);

        List<Box> lightBoxes = storage.getAllWeightLessThan(4.0);
        System.out.println("Light boxes: " + lightBoxes.size());

        storage.updateOfficeNumber(box -> box.getRecipient().equals("Bharath"), 3);

        List<Box> updatedBoxes = storage.searchBoxes(box -> box.getRecipient().equals("Bharath"));
        System.out.println("Updated office for Bharath: " + updatedBoxes.get(0).getOffice()); // Should print 3
    }
}