package org.onboard.collections.postserviceparcelmanagement;

/**
 *
 * In this task, you will need to organize parcel management at the New Post warehouse. The Box class describes a parcel with the following characteristics:
 * id, sender, recipient, weight, volume, cost, city, and office. All characteristics are passed to the constructor to create an object, except for the id. The parcel id is a positive integer and is created in the constructor according to the following rule:
 * The first parcel gets the value 1, the second gets 2, the third gets 3, etc.
 * You must not change this class.
 * The NewPostOfficeManagement interface has several methods for searching and sorting parcels in a storage:
 * Optional<Box> getBoxById(int id)
 * Returns a parcel by the specified id
 * String getDescSortedBoxesByWeight()
 * Gets all parcels as a String sorted in order of decreasing weight
 * String getAscSortedBoxesByCost()
 * Gets all parcels as a String, sorted in ascending order of cost
 * List<Box> getBoxesByRecipient(String recipient)
 * Gets all parcels of the specified recipient
 *
 * Now, please proceed to the NewPostOfficeManagementImpl class, which implements the NewPostOfficeManagement interface.
 * Details:
 * The getById and getBoxesByRecipient methods for searching for parcels must use the binarySearch() method of the Collections class.
 * The getBoxesByRecipient method returns an empty collection if there are no parcels to the specified recipient.
 * Note that before searching, parcels must be sorted based on the required criteria.
 * The getDescSortedBoxesByWeight and getAscSortedBoxesByCost methods for sorting parcels can use the sort() method of the List interface or the Collections class with an appropriate Comparator.
 * The getDescSortedBoxesByWeight and getAscSortedBoxesByCost methods create the resulting string in the form "parcel\n".
 * The getBoxesByRecipient method implementation must not allow null values. In such cases, the java.lang.NullPointerException is thrown.
 *
 * Restrictions
 * You may not use lambdas or streams to complete this task.
 */

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

