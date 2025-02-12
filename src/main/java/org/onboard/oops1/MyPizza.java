package org.onboard.oops1;

public class MyPizza {
    public static void main(String[] args) {
        Pizza myPizza = new Pizza(new StandardBase());

        myPizza.addTopping(new CornTopping());
        myPizza.addTopping(new MushroomTopping());
        myPizza.calculatePrice();
        myPizza.displayPrice();

    }
}
