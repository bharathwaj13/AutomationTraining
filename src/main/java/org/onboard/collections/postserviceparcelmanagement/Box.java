package org.onboard.collections.postserviceparcelmanagement;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
class Box {
    private static int counter = 0;
    private int id;
    private String sender;
    private String recipient;
    private double weight;
    private double volume;
    private double cost;
    private String city;
    private String office;

    public Box(String sender, String recipient, double weight, double volume, double cost, String city, String office) {
        this.id = ++counter;
        this.sender = sender;
        this.recipient = recipient;
        this.weight = weight;
        this.volume = volume;
        this.cost = cost;
        this.city = city;
        this.office = office;
    }
}

