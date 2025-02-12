package org.onboard.designpattern.decorator;

public class DesktopWebPage implements WebPage{

    private int rank=20;
    @Override
    public int getRank() {
        return rank;
    }

    @Override
    public String getDescription() {
        return "You are in Desktop Web Page";
    }
}
