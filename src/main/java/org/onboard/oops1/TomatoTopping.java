package org.onboard.oops1;

public class TomatoTopping extends Topping{

    public TomatoTopping(){
        super("Tomato",25f);
    }

    @Override
    public String getDescription() {
        return "Topping contains red savoury Tomatoes";
    }
}
