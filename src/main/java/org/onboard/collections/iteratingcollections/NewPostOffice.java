package org.onboard.collections.iteratingcollections;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class NewPostOffice {
    private Collection<Box> officeParcels;

    public NewPostOffice() {
        officeParcels = new ArrayList<>();
    }

    public Collection<Box> getListBox() {
        return officeParcels;
    }

    public static BigDecimal calculateCostOfBox(double weight, double volume, int value) {
        double costPerKg = 5.0;
        double costPerCbm = 100.0;
        double valueCoefficient = 0.02;

        BigDecimal cost = BigDecimal.valueOf(weight * costPerKg + volume * costPerCbm + value * valueCoefficient);
        return cost.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public boolean addBox(String sender, String recipient, double weight, double volume, int value) {
            BigDecimal shippingCost = calculateCostOfBox(weight, volume, value);
            Box newBox = new Box(sender, recipient, weight, volume, value, shippingCost);
            officeParcels.add(newBox);
            return true;
    }

    public Collection<Box> deliveryBoxToRecipient(String recipient) {
        Collection<Box> deliveredParcels = new ArrayList<>();
        Iterator<Box> iterator = officeParcels.iterator();

        while (iterator.hasNext()) {
            Box box = iterator.next();
            if (box.getRecipient().equals(recipient)) {
                deliveredParcels.add(box);
                iterator.remove();
            }
        }

        return deliveredParcels;
    }

    public void declineCostOfBox(double percent) {

        Iterator<Box> iterator = officeParcels.iterator();
        while (iterator.hasNext()) {
            Box box = iterator.next();
            BigDecimal currentCost = box.getShippingCost();
            BigDecimal discount = currentCost.multiply(BigDecimal.valueOf(percent / 100));
            BigDecimal newCost = currentCost.subtract(discount);
            box.setShippingCost(newCost);
        }
    }
}

