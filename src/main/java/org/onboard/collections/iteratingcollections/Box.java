package org.onboard.collections.iteratingcollections;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Box {
    private String sender;
    private String recipient;
    private double weight;
    private double volume;
    private int value;
    private BigDecimal shippingCost;

    public Box(String sender, String recipient, double weight, double volume, int value, BigDecimal shippingCost) {
        if (weight < 0.5 || weight > 20.0) {
            throw new IllegalArgumentException("Weight must be between 0.5 and 20.0 kg");
        }
        if (volume <= 0 || volume >= 0.25) {
            throw new IllegalArgumentException("Volume must be greater than 0 and less than 0.25 m³");
        }
        if (value <= 0) {
            throw new IllegalArgumentException("Value must be greater than 0");
        }

        this.sender = sender;
        this.recipient = recipient;
        this.weight = weight;
        this.volume = volume;
        this.value = value;
        this.shippingCost = shippingCost;
    }

   /* private BigDecimal calculateCost() {

        double costPerKg = 5.0;
        double costPerCbm = 100.0;
        double valueCoefficient = 0.02;

        BigDecimal cost = BigDecimal.valueOf(weight * costPerKg + volume * costPerCbm + value * valueCoefficient);
        return cost.setScale(2, BigDecimal.ROUND_HALF_UP);  // Round to two decimal places
    }*/
}