package org.onboard.designpattern.strategy;

public class ShareBySocialMedia implements ShareStrategy{
    @Override
    public void sharePhoto(String photo) {
        System.out.println("Share photos through social media");
    }
}
