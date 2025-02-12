package org.onboard.oops1;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private Base base;
    private List<Topping> toppingList = new ArrayList<>();
    private float totalPrice;

    public Pizza(Base base) {
        this.base = base;
    }

    public void addTopping(Topping topping){
        toppingList.add(topping);
    }

    public void calculatePrice() {
        totalPrice = base.getPrice();
        for (Topping eachTopping : toppingList) {
            totalPrice += eachTopping.getPrice();
        }
    }

    public void displayPrice() {
        System.out.println(" The price of Pizza with Base: " + base.getName() + " and Topping:");
        for (Topping eachTopping : toppingList) {
            System.out.println(eachTopping.getName());
            System.out.println(eachTopping.getDescription());
        }
        System.out.println(totalPrice);
    }
}
