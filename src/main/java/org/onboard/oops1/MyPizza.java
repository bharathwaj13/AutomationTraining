package org.onboard.oops1;

/**
 *
 * 1. I have a pizza shop, which offers a Standard or Soft base. It also offers a selection of toppings from Tomato,  corn, mushrooms. Customers can choose one base and many toppings. The cost of the pizza is the cost of the base plus the cost of the selected toppings.
 * Write code to represent this model in an Object-Oriented approach and calculate the cost of a given pizza.
 */

public class MyPizza {
    public static void main(String[] args) {
        Pizza myPizza = new Pizza(new StandardBase());

        myPizza.addTopping(new CornTopping());
        myPizza.addTopping(new MushroomTopping());
        myPizza.calculatePrice();
        myPizza.displayPrice();

    }
}
