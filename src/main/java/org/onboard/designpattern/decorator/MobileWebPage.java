package org.onboard.designpattern.decorator;

public class MobileWebPage implements WebPage {

    private int rank =10;

    @Override
    public int getRank() {
        return rank;
    }

    @Override
    public String getDescription() {
        return "You are in Mobile Web Page";
    }
}