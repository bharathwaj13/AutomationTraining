package org.onboard.oops1;

public class CornTopping extends Topping{
    @Override
    public String getDescription() {
        return "Topping contains delicious, crispy Corn";
    }

    public CornTopping(){
        super("Corn",30f);
    }
}
