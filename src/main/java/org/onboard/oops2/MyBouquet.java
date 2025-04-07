package org.onboard.oops2;

/**
 *
 * 2. A bouquet consists of different types of flowers, Roses, Jasmines, Lilys etc.
 * Consider a rose costs 1$, jasmine costs 2$, Lily costs 3$. The cost of the bouquet is
 * the sum of the cost of the flowers in it.  Use the object-oriented approach to design the
 * above situation and write a utility method to calculate the cost of the given bouquet.
 */

public class MyBouquet {
    public static void main(String[] args) {
        Bouquet bouquet=new Bouquet();
        bouquet.addFlowersToBouquet(new Jasmine());
        bouquet.addFlowersToBouquet(new Rose());
        bouquet.calculatePrice();
        bouquet.displayPrice();
    }

}
