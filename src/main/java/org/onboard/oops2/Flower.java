package org.onboard.oops2;

import lombok.Data;

@Data
public abstract class Flower {

    private String name;
    private float price;


    public Flower(String name, float price) {

        this.name = name;
        this.price = price;
    }

    public abstract String getDescription();


}