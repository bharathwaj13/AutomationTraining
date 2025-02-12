package org.onboard.oops2;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {

    private List<Flower> flowerList = new ArrayList<>();
    private float totalPrice;

    public void addFlowersToBouquet(Flower flower){
        flowerList.add(flower);
    }

    public void calculatePrice(){
        for (Flower eachFlower:flowerList){
            System.out.println(eachFlower.getDescription());
            totalPrice+=eachFlower.getPrice();
        }
    }

    public void displayPrice(){
        System.out.println("The Price of the bouquet is: "+totalPrice);
    }
}
