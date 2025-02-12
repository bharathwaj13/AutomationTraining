package org.onboard.oops2;

public class MyBouquet {
    public static void main(String[] args) {
        Bouquet bouquet=new Bouquet();
        bouquet.addFlowersToBouquet(new Jasmine());
        bouquet.addFlowersToBouquet(new Rose());
        bouquet.calculatePrice();
        bouquet.displayPrice();
    }

}
