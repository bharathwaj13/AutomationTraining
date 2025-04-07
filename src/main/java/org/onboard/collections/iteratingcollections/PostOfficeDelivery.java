package org.onboard.collections.iteratingcollections;

/**
 * In this task, you will simulate the work of a new post office that takes parcels weighing between 0.5 and 20 kg and with a maximum volume of 0.25 m3
 * The Box class describes parcels. A parcel has the following characteristics: sender, recipient, weight, volume, and shipping cost. All characteristics except for the shipping cost are passed to the constructor to create an object. The shipping cost is calculated based on the weight, volume, and value of the parcel.
 * The NewPostOffice class has:
 * NewPostOffice()
 * Creates an office (an empty collection of parcels)
 * Collection<Box> getListBox()
 * Returns a collection of parcels in the office
 * static BigDecimal calculateCostOfBox(double weight, double volume, int value)
 * Calculates the cost of a parcel
 *
 * Please proceed to the NewPostOffice class and implement its methods using an iterator:
 * Collection<Box> deliveryBoxToRecipient(String recipient)
 * Returns all parcels of a specified recipient; any parcels found must be removed from the office
 * void declineCostOfBox(double percent)
 * Changes the cost of each parcel in the office by the percentage specified
 * boolean addBox(String sender, String recipient, double weight, double volume, int value)
 * Creates a parcel, calculates its shipping cost, and adds it to the office
 *
 * Details:
 * The sender and receiver must exist.
 * The weight must be 0.5–20.0 kg.
 * The volume must be greater than 0 and less than 0.25 m3.
 * The value must be greater than zero.
 * The cost of a parcel is calculated as follows: the weight is multiplied by the cost of one kilogram, the volume is multiplied by the cost of one cubic meter, the value is multiplied by a given coefficient, then everything is summed up.
 * If the values of the data above are set incorrectly (by specifying invalid values), the java.lang.IllegalArgumentException is thrown.
 *
 * Restriction:
 * You may not use the Lambdas or the Streams API.
 *
 */

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

