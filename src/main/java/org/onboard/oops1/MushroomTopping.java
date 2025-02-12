package org.onboard.oops1;

public class MushroomTopping extends Topping {


    @Override
    public String getDescription() {
        return "Topping contains delicious mushrooms";
    }

    public MushroomTopping(){
        super("Mushroom",35f);
    }
}
