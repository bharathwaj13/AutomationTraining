package org.onboard.oops1;

import lombok.Data;

@Data
public abstract class Base {

    private String name;
    private float price;


    public Base(String name, float price) {

        this.name = name;
        this.price = price;
    }

    public abstract String getDescription();


}