package org.onboard.designpattern.strategy;

public class ShareByText implements ShareStrategy{
    @Override
    public void sharePhoto(String photo) {
        System.out.println("Sharing photo through text");
    }
}
