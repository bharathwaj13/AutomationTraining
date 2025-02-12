package org.onboard.collections.iteratingcollections;

import java.util.Collection;

public class PostOfficeDelivery {

    public static void main(String[] args) {
        NewPostOffice postOffice = new NewPostOffice();

        postOffice.addBox("Bharath", "Test", 10.0, 0.1, 500);
        postOffice.addBox("Test", "Bharath", 5.0, 0.05, 200);
        postOffice.addBox("EPAM", "Bharath", 15.0, 0.2, 1000);

        System.out.println("All parcels in the office:");
        for (Box box : postOffice.getListBox()) {
            System.out.println("Sender: " + box.getSender() + ", Recipient: " + box.getRecipient() + ", Cost: " + box.getShippingCost());
        }

        Collection<Box> deliveredToBharath = postOffice.deliveryBoxToRecipient("Bharath");
        System.out.println("Parcels delivered to Bharath:");
        for (Box box : deliveredToBharath) {
            System.out.println("Sender: " + box.getSender() + ", Recipient: " + box.getRecipient() + ", Cost: " + box.getShippingCost());
        }

        postOffice.declineCostOfBox(10);
        System.out.println("Updated cost after 10% decline:");
        for (Box box : postOffice.getListBox()) {
            System.out.println("Sender: " + box.getSender() + ", Recipient: " + box.getRecipient() + ", Cost: " + box.getShippingCost());
        }
    }
}

