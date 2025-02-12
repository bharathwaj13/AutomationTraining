package org.onboard.designpattern;

public class CandyMakerSingleton {

    private boolean empty;
    private boolean boiled;

    private static volatile CandyMakerSingleton instance;

    private CandyMakerSingleton() {
        empty = true;
        boiled = false;
    }

    public static CandyMakerSingleton getInstance() {
        if (instance == null) {
            synchronized (CandyMakerSingleton.class) {
                if (instance == null) {
                    instance = new CandyMakerSingleton();
                }
            }
        }
        return instance;
    }

    //to fill the boiler it must be empty, and once its full,
    //we set the empty and boiled flags
    public synchronized void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
            // fill the candyMaker with milk and choclate mix
        }
    }

    // To drain the boiler, it must be full(non-empty) and also boiled.
    // Once it is drained, we set the empty back to true
    public synchronized void drain() {
        if (!isEmpty() && isBoiled()) {
            // drain the boiled milk and chocolate
            empty = true;
        }
    }

    // To boil the mixture the boiler has to be full and not already boiled.
    // Once it's boiled we set the boiled flag to true
    public synchronized void boil() {
        if (!isEmpty() && !isBoiled()) {
            // bring the content to boil
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}

